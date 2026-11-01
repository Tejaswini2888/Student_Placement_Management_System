package com.placement.model;

public class Resume {

    private String studentId;
    private String email;
    private String education;
    private String skills;
    private String projects;
    private String certifications;
    private String resumeFilePath;

    public Resume(String studentId, String email,
                  String education, String skills,
                  String projects, String certifications,
                  String resumeFilePath) {

        this.studentId = studentId;
        this.email = email;
        this.education = education;
        this.skills = skills;
        this.projects = projects;
        this.certifications = certifications;
        this.resumeFilePath = resumeFilePath;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public String getEducation() {
        return education;
    }

    public String getSkills() {
        return skills;
    }

    public String getProjects() {
        return projects;
    }

    public String getCertifications() {
        return certifications;
    }

    public String getResumeFilePath() {
        return resumeFilePath;
    }

    public void displayResume() {
        System.out.println("\n===== STUDENT RESUME =====");
        System.out.println("Student ID: " + studentId);
        System.out.println("Email: " + email);
        System.out.println("Education: " + education);
        System.out.println("Skills: " + skills);
        System.out.println("Projects: " + projects);
        System.out.println("Certifications: " + certifications);
        System.out.println("Resume File: " + resumeFilePath);
    }
}
