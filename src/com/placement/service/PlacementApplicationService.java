
package com.placement.service;

import com.placement.model.PlacementApplication;
import com.placement.storage.FileStorage;

import java.util.ArrayList;
import java.util.List;

public class PlacementApplicationService {

    private ArrayList<PlacementApplication> applications = new ArrayList<>();

    public PlacementApplicationService() {
        loadApplications();
    }

    // Load saved applications from the file
    private void loadApplications() {
        List<String> records = FileStorage.loadRecords("applications.txt");

        for (String record : records) {
            try {
                String[] data = record.split(",", -1);

                if (data.length != 4) {
                    continue;
                }

                int applicationId = Integer.parseInt(data[0]);
                int studentId = Integer.parseInt(data[1]);
                int companyId = Integer.parseInt(data[2]);
                String status = data[3];

                if (applicationId > 0
                        && studentId > 0
                        && companyId > 0
                        && isValidStatus(status)
                        && !applicationIdExists(applicationId)
                        && !studentCompanyApplicationExists(studentId, companyId)) {

                    applications.add(new PlacementApplication(
                            applicationId,
                            studentId,
                            companyId,
                            status
                    ));
                }

            } catch (NumberFormatException e) {
                System.out.println("Skipping an invalid application record.");
            }
        }

        System.out.println("Application records loaded: " + applications.size());
    }

    // Save applications to the file
    private void saveApplications() {
        List<String> records = new ArrayList<>();

        for (PlacementApplication application : applications) {
            records.add(
                    application.getApplicationId() + ","
                            + application.getStudentId() + ","
                            + application.getCompanyId() + ","
                            + application.getStatus()
            );
        }

        FileStorage.saveRecords("applications.txt", records);
    }

    // Check whether an application ID already exists
    private boolean applicationIdExists(int applicationId) {
        for (PlacementApplication application : applications) {
            if (application.getApplicationId() == applicationId) {
                return true;
            }
        }

        return false;
    }

    // Check whether a student has already applied to a company
    private boolean studentCompanyApplicationExists(int studentId, int companyId) {
        for (PlacementApplication application : applications) {
            if (application.getStudentId() == studentId
                    && application.getCompanyId() == companyId) {
                return true;
            }
        }

        return false;
    }

    // Validate application status
    private boolean isValidStatus(String status) {
        return "Applied".equals(status)
                || "Selected".equals(status)
                || "Rejected".equals(status);
    }

    // Apply for a company
    public void applyForCompany(
            int applicationId,
            int studentId,
            int companyId,
            StudentService studentService,
            CompanyService companyService) {

        if (applicationId <= 0 || studentId <= 0 || companyId <= 0) {
            System.out.println("All IDs must be positive!");
            return;
        }

        if (applicationIdExists(applicationId)) {
            System.out.println("Application ID already exists!");
            return;
        }

        if (studentCompanyApplicationExists(studentId, companyId)) {
            System.out.println(
                    "This student has already applied to this company!"
            );
            return;
        }

        if (!studentService.studentExists(studentId)) {
            System.out.println("Student not found!");
            return;
        }

        if (!companyService.companyExists(companyId)) {
            System.out.println("Company not found!");
            return;
        }

        double studentCgpa = studentService.getStudentCgpa(studentId);
        double minimumCgpa = companyService.getMinimumCgpa(companyId);

        if (studentCgpa < minimumCgpa) {
            System.out.println(
                    "Student does not meet the minimum CGPA requirement!"
            );
            return;
        }

        PlacementApplication application = new PlacementApplication(
                applicationId,
                studentId,
                companyId,
                "Applied"
        );

        applications.add(application);
        saveApplications();

        System.out.println("Placement application submitted successfully!");
    }

    // Display all applications
    public void viewAllApplications() {
        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (PlacementApplication application : applications) {
            System.out.println("----------------------");
            application.displayApplication();
        }
    }

    // View applications submitted by a particular student
    public void viewApplicationsByStudent(int studentId) {
        if (studentId <= 0) {
            System.out.println("Student ID must be positive!");
            return;
        }

        boolean found = false;

        for (PlacementApplication application : applications) {
            if (application.getStudentId() == studentId) {
                System.out.println("----------------------");
                application.displayApplication();
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No applications found for Student ID: " + studentId
            );
        }
    }

    // Display placement statistics
    public void displayPlacementStatistics() {
        int totalApplications = applications.size();
        int selected = 0;
        int rejected = 0;
        int applied = 0;

        for (PlacementApplication application : applications) {
            switch (application.getStatus()) {
                case "Selected":
                    selected++;
                    break;

                case "Rejected":
                    rejected++;
                    break;

                case "Applied":
                    applied++;
                    break;
            }
        }

        System.out.println("\n===== PLACEMENT STATISTICS =====");
        System.out.println("Total Applications: " + totalApplications);
        System.out.println("Selected: " + selected);
        System.out.println("Rejected: " + rejected);
        System.out.println("In Progress: " + applied);
    }

    // Update an application's status
    public void updateApplicationStatus(int applicationId, String newStatus) {
        if (applicationId <= 0) {
            System.out.println("Application ID must be positive!");
            return;
        }

        if (newStatus != null) {
            newStatus = newStatus.trim();
        }

        if (!isValidStatus(newStatus)) {
            System.out.println(
                    "Status must be Applied, Selected, or Rejected!"
            );
            return;
        }

        for (PlacementApplication application : applications) {
            if (application.getApplicationId() == applicationId) {
                application.setStatus(newStatus);
                saveApplications();

                System.out.println("Application status updated!");
                return;
            }
        }

        System.out.println("Application not found.");
    }
}

