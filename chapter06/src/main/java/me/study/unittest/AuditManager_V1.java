package me.study.unittest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Example 6.8
// 최초의 상태
public class AuditManager_V1 {

    private final int maxEntriesPerFile;
    private final String directoryName;

    public AuditManager_V1(int maxEntriesPerFile, String directoryName) {
        this.maxEntriesPerFile = maxEntriesPerFile;
        this.directoryName = directoryName;
    }

    public void addRecord(String visitorName, LocalDateTime timeOfVisit) throws IOException {
        final File dir = new File(directoryName);
        final List<String> filePaths = Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                                             .map(File::getPath)
                                             .collect(Collectors.toList());
        final List<Entry<Integer, String>> sorted = sortByIndex(filePaths);

        final String newRecord = String.format("%s;%s",
                                               visitorName,
                                               timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
        );

        if (sorted.isEmpty()) {
            final File newFile = new File(directoryName + "/audit_1.txt");
            if (newFile.createNewFile()) {
                try (final FileWriter fileWriter = new FileWriter(newFile)) {
                    fileWriter.write(newRecord);
                }
                return;
            }
            else {
                throw new IllegalStateException("\"audit_1.txt\" named file already exists.");
            }
        }

        final Entry<Integer, String> latestFile = sorted.get(sorted.size() - 1);
        final int currentFileIndex = latestFile.getKey();
        final String currentFilePath = latestFile.getValue();
        final List<String> lines = Files.readAllLines(Path.of(currentFilePath), StandardCharsets.UTF_8);

        if (lines.size() < maxEntriesPerFile) {
            lines.add(newRecord);
            try (final FileWriter fileWriter = new FileWriter(currentFilePath)) {
                fileWriter.write(String.join("\r\n", lines));
            }
        }
        else {
            final int newIndex = currentFileIndex + 1;
            final String newName = String.format("audit_%d.txt", newIndex);
            final File newFile = new File(directoryName + "/" + newName);
            if (newFile.createNewFile()) {
                try (final FileWriter fileWriter = new FileWriter(newFile)) {
                    fileWriter.write(newRecord);
                }
            }
        }
    }

    private List<Entry<Integer, String>> sortByIndex(List<String> files) {
        final Map<Integer, String> map = new HashMap<>();
        IntStream.range(0, files.size())
                 .forEach(i -> map.put(getIndex(files.get(i)), files.get(i)));

        final List<Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Entry.comparingByKey());
        return entries;
    }

    private int getIndex(String filePath) {
        final int underscoreIdx = filePath.lastIndexOf("_");
        final int dotIdx = filePath.lastIndexOf(".");
        return Integer.parseInt(filePath.substring(underscoreIdx + 1, dotIdx));
    }
}
