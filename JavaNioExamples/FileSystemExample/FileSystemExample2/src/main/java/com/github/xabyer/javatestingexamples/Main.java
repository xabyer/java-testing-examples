package com.github.xabyer.javatestingexamples;
// Java Program to illustrate FileSystems Class by
// creating new file system using newFileSystem() method

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {

        try {
            // Java Program to illustrate FileSystems Class by
            // creating new file system using newFileSystem() method
            Map<String, String> env = new HashMap<>();

            // Getting path of zip file
            Path zipPath = Paths.get("ZipFile.zip");

            // Creating URI from zip path received
            URI uri = new URI("jar:file", zipPath.toUri().getPath(), null);

            //Create new file system from uri
            try (FileSystem fileSystem = FileSystems.newFileSystem(uri, env)) {
                IO.println("FileSystem created successfully");

                if(fileSystem.isOpen())
                    IO.println("File system is open");

                else
                    IO.println("File system is close");
            }

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
