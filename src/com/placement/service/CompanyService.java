
package com.placement.service;

import com.placement.model.Company;
import java.util.ArrayList;

public class CompanyService {

    private ArrayList<Company> companies = new ArrayList<>();

    // Add a company
    public void addCompany(Company company) {

        if (company.getCompanyId() <= 0) {
            System.out.println("Company ID must be positive!");
            return;
        }

        if (company.getCompanyName() == null
                || company.getCompanyName().trim().isEmpty()) {
            System.out.println("Company name cannot be empty!");
            return;
        }

        if (company.getJobRole() == null
                || company.getJobRole().trim().isEmpty()) {
            System.out.println("Job role cannot be empty!");
            return;
        }

        if (!Double.isFinite(company.getPackageLpa())
                || company.getPackageLpa() < 0) {
            System.out.println("Package cannot be negative!");
            return;
        }

        if (!Double.isFinite(company.getMinimumCgpa())
                || company.getMinimumCgpa() < 0
                || company.getMinimumCgpa() > 10) {
            System.out.println("Minimum CGPA must be between 0 and 10!");
            return;
        }

        for (Company existing : companies) {
            if (existing.getCompanyId() == company.getCompanyId()) {
                System.out.println("Company ID already exists!");
                return;
            }
        }

        companies.add(company);
        System.out.println("Company added successfully!");
    }

    // View all companies
    public void viewAllCompanies() {

        if (companies.isEmpty()) {
            System.out.println("No company records found.");
            return;
        }

        for (Company company : companies) {
            System.out.println("----------------------");
            company.displayCompany();
        }
    }

    // Search company by ID
    public boolean searchCompany(int companyId) {

        for (Company company : companies) {
            if (company.getCompanyId() == companyId) {
                System.out.println("Company found!");
                company.displayCompany();
                return true;
            }
        }

        System.out.println("Company not found.");
        return false;
    }
}

