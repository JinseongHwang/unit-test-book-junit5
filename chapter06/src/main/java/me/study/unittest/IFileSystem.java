package me.study.unittest;

import java.util.List;

public interface IFileSystem {

    List<String> getFiles(String directoryName);
    void writeAllText(String filePath, String content);
    List<String> readAllLines(String filePath);
}
