
package com.placement.storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileStorage {

    private static final String FOLDER_NAME = "data";

    // Save records to a file
    public static void saveRecords(
            String fileName,
            List<String> records) {

        try {
            Files.createDirectories(Path.of(FOLDER_NAME));

            Path filePath = Path.of(FOLDER_NAME, fileName);

            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(filePath.toFile()))) {

                for (String record : records) {
                    writer.write(record);
                    writer.newLine();
                }
            }

            System.out.println("Records saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }

    // Read records from a file
    public static List<String> loadRecords(String fileName) {

        try {
            Path filePath = Path.of(FOLDER_NAME, fileName);

            if (!Files.exists(filePath)) {
                return List.of();
            }

            return Files.readAllLines(filePath);

        } catch (IOException e) {
            System.out.println("Error loading records: " + e.getMessage());
            return List.of();
        }
    }
}

