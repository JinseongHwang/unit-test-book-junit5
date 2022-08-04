package me.study.unittest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

// Example 6.12
// 함수형 아키텍처
public class AuditManager_V3 {

    private final int maxEntriesPerFile;

    public AuditManager_V3(int maxEntriesPerFile) {
        this.maxEntriesPerFile = maxEntriesPerFile;
    }

    public FileUpdate addRecord(List<FileContent> files, String visitorName, LocalDateTime timeOfVisit) throws IOException {
        final List<Entry<Integer, FileContent>> sorted = sortByIndex(files);

        final String newRecord = String.format("%s;%s",
                                               visitorName,
                                               timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
        );

        if (sorted.isEmpty()) {
            return new FileUpdate("audit_1.txt", newRecord);
        }

        final Entry<Integer, FileContent> latestFile = sorted.get(sorted.size() - 1);
        final Integer currentFileIndex = latestFile.getKey();
        final FileContent currentFile = latestFile.getValue();
        final List<String> lines = Files.readAllLines(Path.of(currentFile.fileName), StandardCharsets.UTF_8);

        if (lines.size() < maxEntriesPerFile) {
            lines.add(newRecord);
            final String newContent = String.join("\r\n", lines);
            return new FileUpdate(currentFile.fileName, newContent);
        }
        else {
            final int newIndex = currentFileIndex + 1;
            final String newName = String.format("audit_%d.txt", newIndex);
            return new FileUpdate(newName, newRecord);
        }
    }

    private List<Entry<Integer, FileContent>> sortByIndex(List<FileContent> files) {
        final Map<Integer, FileContent> map = new HashMap<>();
        IntStream.range(0, files.size())
                 .forEach(i -> map.put(getIndex(files.get(i).fileName), files.get(i)));

        final List<Entry<Integer, FileContent>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Entry.comparingByKey());
        return entries;
    }

    private int getIndex(String filePath) {
        final int underscoreIdx = filePath.lastIndexOf("_");
        final int dotIdx = filePath.lastIndexOf(".");
        return Integer.parseInt(filePath.substring(underscoreIdx + 1, dotIdx));
    }
}
