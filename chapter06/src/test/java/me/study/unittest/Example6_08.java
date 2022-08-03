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
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Example6_08 {

    @Test
    void a() throws Exception {
        String path = "123/sdf/audit_5234.txt";

        final int i = path.lastIndexOf("_");
        final int j = path.lastIndexOf(".");
        final String substring = path.substring(i + 1, j);
        Assertions.assertThat(substring).isEqualTo("5234");
    }

    @Test
    void b() throws Exception {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(4, "a");
        mp.put(-1, "b");
        mp.put(1, "c");
        mp.put(3, "d");

        final List<Entry<Integer, String>> entries = new ArrayList<>(mp.entrySet());
        entries.sort(Entry.comparingByKey());
        for (Entry<Integer, String> entry : entries) {
            System.out.println(entry);
        }
    }

    @Test
    public void addRecord() throws IOException {
        String visitorName = "Jinseong2";
        LocalDateTime timeOfVisit = LocalDateTime.now();

        final File dir = new File("/Users/jinseonghwang/IdeaProjects/unit-test-book-junit5/chapter06/data");
        final List<String> filePaths = Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                                             .map(File::getPath)
                                             .collect(Collectors.toList());
        final List<Entry<Integer, String>> sorted = sortByIndex(filePaths);

        final String newRecord = String.format("%s;%s", visitorName, timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

        if (sorted.isEmpty()) {
            final File newFile = new File(dir.getPath() + "/audit_1.txt");
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

        if (lines.size() < 2) {
            try (final FileWriter fileWriter = new FileWriter(currentFilePath)) {
                lines.add(newRecord);
                fileWriter.write(String.join("\r\n", lines));
            }
        }
        else {
            final int newIndex = currentFileIndex + 1;
            final String newName = String.format("audit_%d.txt", newIndex);
            final File newFile = new File(dir.getPath() + "/" + newName);
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
