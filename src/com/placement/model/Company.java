
package com.placement.model;

public class Company {

    private int companyId;
    private String companyName;
    private String jobRole;
    private double packageLpa;
    private double minimumCgpa;

    // Constructor
    public Company(int companyId, String companyName,
                   String jobRole, double packageLpa,
                   double minimumCgpa) {

        this.companyId = companyId;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.packageLpa = packageLpa;
        this.minimumCgpa = minimumCgpa;
    }

    // Getters
    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public double getPackageLpa() {
        return packageLpa;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    // Display company details
    public void displayCompany() {
        System.out.println("Company ID: " + companyId);
        System.out.println("Company Name: " + companyName);
        System.out.println("Job Role: " + jobRole);
        System.out.println("Package: " + packageLpa + " LPA");
        System.out.println("Minimum CGPA: " + minimumCgpa);
    }
}
