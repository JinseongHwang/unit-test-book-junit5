package me.study.unittest;

import java.util.List;

// Example 6.12
public class FileContent {

    public final String fileName;
    public final List<String> lines;

    public FileContent(String fileName, List<String> lines) {
        this.fileName = fileName;
        this.lines = lines;
    }
}
