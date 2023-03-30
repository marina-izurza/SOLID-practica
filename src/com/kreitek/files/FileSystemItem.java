package com.kreitek.files;

import java.util.List;

public interface FileSystemItem {

    String getName();
    void setName(String name);
    FileSystemItem getParent();
    void setParent(FileSystemItem directory);

    String getFullPath();
    String getExtension();

    int getSize();
    void setPosition(int numberOfBytesFromBeginning);

    List<FileSystemItem> listFiles();
    void addFile(FileSystemItem file);
    void removeFile(FileSystemItem file);

    void open();
    void close();

    byte[] read(int numberOfBytesToRead);
    void write(byte[] buffer);

}
