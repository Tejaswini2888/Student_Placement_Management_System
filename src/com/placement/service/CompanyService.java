
package com.placement.service;

import com.placement.model.Company;
import com.placement.model.Student;
import com.placement.storage.FileStorage;

import java.util.ArrayList;
import java.util.List;

public class CompanyService {

    private ArrayList<Company> companies = new ArrayList<>();

    public CompanyService() {
        loadCompanies();
    }

    // Load saved companies
    private void loadCompanies() {
        List<String> records = FileStorage.loadRecords("companies.txt");

        for (String record : records) {
            try {
                String[] data = record.split(",", -1);

                if (data.length != 5) {
                    continue;
                }

                Company company = new Company(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3]),
                        Double.parseDouble(data[4])
                );

                if (isValidCompany(company)
                        && !companyIdExists(company.getCompanyId())) {
                    companies.add(company);
                }

            } catch (NumberFormatException e) {
                System.out.println("Skipping an invalid company record.");
            }
        }

        System.out.println("Company records loaded: " + companies.size());
    }

    // Save companies
    private void saveCompanies() {
        List<String> records = new ArrayList<>();

        for (Company company : companies) {
            records.add(
                    company.getCompanyId() + ","
                            + company.getCompanyName() + ","
                            + company.getJobRole() + ","
                            + company.getPackageLpa() + ","
                            + company.getMinimumCgpa()
            );
        }

        FileStorage.saveRecords("companies.txt", records);
    }

    // Validate company details
    private boolean isValidCompany(Company company) {
        return company.getCompanyId() > 0
                && company.getCompanyName() != null
                && !company.getCompanyName().trim().isEmpty()
                && company.getJobRole() != null
                && !company.getJobRole().trim().isEmpty()
                && Double.isFinite(company.getPackageLpa())
                && company.getPackageLpa() >= 0
                && Double.isFinite(company.getMinimumCgpa())
                && company.getMinimumCgpa() >= 0
                && company.getMinimumCgpa() <= 10;
    }

    private boolean companyIdExists(int companyId) {
        for (Company company : companies) {
            if (company.getCompanyId() == companyId) {
                return true;
            }
        }
        return false;
    }

    // Add company
    public void addCompany(Company company) {
        if (!isValidCompany(company)) {
            System.out.println("Invalid company details!");
            return;
        }

        if (companyIdExists(company.getCompanyId())) {
            System.out.println("Company ID already exists!");
            return;
        }

        companies.add(company);
        saveCompanies();
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

    // Show students eligible for a company
    public void showEligibleStudents(
            int companyId,
            StudentService studentService) {

        Company selectedCompany = null;

        for (Company company : companies) {
            if (company.getCompanyId() == companyId) {
                selectedCompany = company;
                break;
            }
        }

        if (selectedCompany == null) {
            System.out.println("Company not found.");
            return;
        }

        System.out.println("\nEligible students for "
                + selectedCompany.getCompanyName());

        System.out.println("Required minimum CGPA: "
                + selectedCompany.getMinimumCgpa());

        studentService.showEligibleStudents(
                selectedCompany.getMinimumCgpa());
    }

    public boolean companyExists(int companyId) {
        for (Company company : companies) {
            if (company.getCompanyId() == companyId) {
                return true;
            }
        }
        return false;
    }

    public double getMinimumCgpa(int companyId) {
        for (Company company : companies) {
            if (company.getCompanyId() == companyId) {
                return company.getMinimumCgpa();
            }
        }
        return -1;
    }

}



