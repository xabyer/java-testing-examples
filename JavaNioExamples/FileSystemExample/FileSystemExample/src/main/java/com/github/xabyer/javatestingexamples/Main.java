package com.github.xabyer.javatestingexamples;

// Java Program to illustrate FileSystems Class by
// creating a new file system using getDefault() method and
// printing its file stores and root directories

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {
    static void main() {
        try {
            // Create a new file system by
            // creating object of FileSystem class
            // using getDefault() method
            FileSystem fileSystem = FileSystems.getDefault();

            //Display commands only
            System.out.println("File System created Successfully");

            System.out.println("Underlying the file stores of this FileSystem:");

            // Printing the underlying file stores of this
            // FileSystem using for each loop
            for(FileStore store: fileSystem.getFileStores()) {
                System.out.println(store.toString());
            }

            System.out.println("Root directories of FileSystem:");

            // Printing the root directories of this
            // FileSystem using for each loop
            for (Path rootdir: fileSystem.getRootDirectories()) {
                System.out.println(rootdir.toString());
            }

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
