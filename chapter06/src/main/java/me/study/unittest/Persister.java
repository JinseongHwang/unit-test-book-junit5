package me.study.unittest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Example 6.13
public class Persister {

    public List<FileContent> readDirectory(String directoryName) throws IOException {
        final File dir = new File(directoryName);
        final List<String> filePaths = Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                                             .map(File::getPath)
                                             .collect(Collectors.toList());
        List<FileContent> fileContents = new ArrayList<>();
        for (String filePath : filePaths) {
            FileContent fileContent = new FileContent(
                filePath,
                Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8)
            );
            fileContents.add(fileContent);
        }
        return fileContents;
    }

    public void applyUpdate(String directoryName, FileUpdate update) throws IOException {
        final File newFile = new File(directoryName + "/" + update.fileName);
        if (newFile.createNewFile()) {
            try (final FileWriter fileWriter = new FileWriter(newFile)) {
                fileWriter.write(update.newContent);
            }
        }
        else {
            try (final FileWriter fileWriter = new FileWriter(newFile)) {
                fileWriter.write(update.newContent);
            }
        }
    }
}
