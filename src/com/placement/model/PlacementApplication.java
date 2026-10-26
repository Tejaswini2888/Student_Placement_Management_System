
package com.placement.model;

public class PlacementApplication {

    private int applicationId;
    private int studentId;
    private int companyId;
    private String status;

    // Constructor
    public PlacementApplication(int applicationId, int studentId,
                                int companyId, String status) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.companyId = companyId;
        this.status = status;
    }

    // Getters
    public int getApplicationId() {
        return applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getStatus() {
        return status;
    }

    // Setter
    public void setStatus(String status) {
        this.status = status;
    }

    // Display application details
    public void displayApplication() {
        System.out.println("Application ID: " + applicationId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Company ID: " + companyId);
        System.out.println("Status: " + status);
    }
}



