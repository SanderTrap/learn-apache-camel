package com.learncamel.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CopyFilesWithoutCamel {

    public static void main(String[] args) throws IOException {

        // Step 1: Create a file Object to read the directories.
        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        // Step 2: Read the files from the directory and iterate the files.
        File[] files = inputDirectory.listFiles();

        for (File source : files) {
            if (source.isFile()) {
                File dest = new File (
                        outputDirectory.getPath()
                                + File.separator
                                + source.getName());

                // Step 3: Create the output stream and read the files.
                OutputStream oStream = new FileOutputStream(dest);
                byte[] buffer = new byte[(int) source.length()];
                FileInputStream iStream = new FileInputStream(source);
                try {
                    oStream.write(buffer);
                } finally {
                    // Step 4: Close the streams.
                    oStream.close();
                    iStream.close();
                }
            }
        }
    }
}
