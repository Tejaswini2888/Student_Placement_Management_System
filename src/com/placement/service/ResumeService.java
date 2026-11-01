
package com.placement.service;

import com.placement.model.Resume;
import com.placement.storage.FileStorage;

import java.util.ArrayList;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ResumeService {

    private ArrayList<Resume> resumes = new ArrayList<>();

    public ResumeService() {
        loadResumes();
    }

    // Encode data before saving
    private String encode(String value) {
        return Base64.getEncoder().encodeToString(
                value.getBytes(StandardCharsets.UTF_8)
        );
    }

    // Decode data after loading
    private String decode(String value) {
        return new String(
                Base64.getDecoder().decode(value),
                StandardCharsets.UTF_8
        );
    }

    // Load resumes from file
    private void loadResumes() {

        List<String> records =
                FileStorage.loadRecords("resumes.txt");

        for (String record : records) {
            try {
                String[] data = record.split(",", -1);

                if (data.length != 7) {
                    continue;
                }

                Resume resume = new Resume(
                        decode(data[0]),
                        decode(data[1]),
                        decode(data[2]),
                        decode(data[3]),
                        decode(data[4]),
                        decode(data[5]),
                        decode(data[6])
                );

                if (!hasResume(resume.getStudentId())) {
                    resumes.add(resume);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Skipping an invalid resume record."
                );
            }
        }

        System.out.println(
                "Resume records loaded: " + resumes.size()
        );
    }

    // Save resumes to file
    private void saveResumes() {

        List<String> records = new ArrayList<>();

        for (Resume resume : resumes) {

            String record =
                    encode(resume.getStudentId()) + ","
                            + encode(resume.getEmail()) + ","
                            + encode(resume.getEducation()) + ","
                            + encode(resume.getSkills()) + ","
                            + encode(resume.getProjects()) + ","
                            + encode(resume.getCertifications()) + ","
                            + encode(resume.getResumeFilePath());

            records.add(record);
        }

        FileStorage.saveRecords("resumes.txt", records);
    }

    // Validate PDF file path
    public boolean isValidPdf(String filePath) {

        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Resume file path cannot be empty!");
            return false;
        }

        try {
            Path path = Path.of(filePath.trim());

            if (!Files.exists(path)) {
                System.out.println("Resume file does not exist!");
                return false;
            }

            if (!Files.isRegularFile(path)) {
                System.out.println("Please select a valid file!");
                return false;
            }

            if (!path.getFileName().toString()
                    .toLowerCase().endsWith(".pdf")) {
                System.out.println("Only PDF files are allowed!");
                return false;
            }

            return true;

        } catch (Exception e) {
            System.out.println("Invalid file path!");
            return false;
        }
    }

    // Add resume
    public void addResume(Resume resume) {

        if (hasResume(resume.getStudentId())) {
            System.out.println(
                    "Resume already exists for this student!"
            );
            return;
        }

        resumes.add(resume);
        saveResumes();

        System.out.println("Resume added successfully!");
    }

    // Update existing resume
    public void updateResume(
            String studentId,
            Resume updatedResume) {

        for (int i = 0; i < resumes.size(); i++) {

            if (resumes.get(i).getStudentId()
                    .equalsIgnoreCase(studentId)) {

                resumes.set(i, updatedResume);

                saveResumes();

                System.out.println(
                        "Resume updated successfully!"
                );
                return;
            }
        }

        System.out.println("Resume not found!");
    }

    // Delete existing resume
    public void deleteResume(String studentId) {

        boolean removed = resumes.removeIf(
                resume -> resume.getStudentId()
                        .equalsIgnoreCase(studentId)
        );

        if (removed) {
            saveResumes();
            System.out.println("Resume deleted successfully!");
        } else {
            System.out.println("Resume not found!");
        }
    }

    // Search resume by Student ID
    public Resume getResumeByStudentId(String studentId) {

        for (Resume resume : resumes) {

            if (resume.getStudentId()
                    .equalsIgnoreCase(studentId)) {
                return resume;
            }
        }

        return null;
    }

    // Check resume submission
    public boolean hasResume(String studentId) {
        return getResumeByStudentId(studentId) != null;
    }

    // View all resumes
    public void viewAllResumes() {

        if (resumes.isEmpty()) {
            System.out.println("No resumes available.");
            return;
        }

        for (Resume resume : resumes) {
            System.out.println("----------------------");
            resume.displayResume();
        }
    }
}
