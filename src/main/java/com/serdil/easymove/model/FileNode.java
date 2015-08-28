package com.serdil.easymove.model;

/**
 * Created by Sinan Erdil on 26.08.2015.
 */
public class FileNode {
    private boolean isFolder;
    private FileNode[] children;

    private String name;
    private byte[] data;

    public FileNode(String name, byte[] data, FileNode[] children) {
        this.children = children;
        this.name = name;
        this.data = data;
        this.isFolder = true;
    }

    public FileNode(String name, byte[] data) {
        this.name = name;
        this.data = data;
        this.isFolder = false;
    }

    public void setChildren(FileNode[] children) {
        this.children = children;
        this.isFolder = true;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public FileNode[] getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }
}
