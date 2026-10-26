
package com.placement;

import com.placement.model.Student;
import com.placement.model.Company;
import com.placement.service.StudentService;
import com.placement.service.CompanyService;
import com.placement.service.PlacementApplicationService;
import com.placement.util.InputUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CompanyService companyService = new CompanyService();
        PlacementApplicationService applicationService =
                new PlacementApplicationService();

        int choice = 0;

        do {
            System.out.println("\n===== STUDENT PLACEMENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Company");
            System.out.println("7. View All Companies");
            System.out.println("8. Search Company");
            System.out.println("9. View Eligible Students");
            System.out.println("10. Apply for a Company");
            System.out.println("11. View All Applications");
            System.out.println("12. Update Application Status");
            System.out.println("13. View Applications by Student");
            System.out.println("14. View Placement Statistics");
            System.out.println("15. Exit");

            choice = InputUtil.readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1: {
                    int studentId = InputUtil.readInt(sc, "Enter Student ID: ");

                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    double cgpa = InputUtil.readDouble(sc, "Enter CGPA: ");

                    sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    Student student = new Student(
                            studentId, name, department, cgpa, email);

                    studentService.addStudent(student);
                    break;
                }

                case 2:
                    studentService.viewAllStudents();
                    break;

                case 3: {
                    int searchId = InputUtil.readInt(
                            sc, "Enter Student ID to search: ");
                    studentService.searchStudent(searchId);
                    break;
                }

                case 4: {
                    int updateId = InputUtil.readInt(
                            sc, "Enter Student ID to update: ");

                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    double newCgpa = InputUtil.readDouble(
                            sc, "Enter New CGPA: ");

                    sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    studentService.updateStudent(
                            updateId, newName, newDepartment,
                            newCgpa, newEmail);
                    break;
                }

                case 5: {
                    int deleteId = InputUtil.readInt(
                            sc, "Enter Student ID to delete: ");
                    studentService.deleteStudent(deleteId);
                    break;
                }

                case 6: {
                    int companyId = InputUtil.readInt(
                            sc, "Enter Company ID: ");

                    sc.nextLine();
                    System.out.print("Enter Company Name: ");
                    String companyName = sc.nextLine();

                    System.out.print("Enter Job Role: ");
                    String jobRole = sc.nextLine();

                    double packageLpa = InputUtil.readDouble(
                            sc, "Enter Package (LPA): ");

                    double minimumCgpa = InputUtil.readDouble(
                            sc, "Enter Minimum CGPA: ");

                    sc.nextLine();

                    Company company = new Company(
                            companyId, companyName, jobRole,
                            packageLpa, minimumCgpa);

                    companyService.addCompany(company);
                    break;
                }

                case 7:
                    companyService.viewAllCompanies();
                    break;

                case 8: {
                    int searchCompanyId = InputUtil.readInt(
                            sc, "Enter Company ID to search: ");
                    companyService.searchCompany(searchCompanyId);
                    break;
                }

                case 9: {
                    int eligibilityCompanyId = InputUtil.readInt(
                            sc, "Enter Company ID: ");

                    companyService.showEligibleStudents(
                            eligibilityCompanyId, studentService);
                    break;
                }

                case 10: {
                    int applicationId = InputUtil.readInt(
                            sc, "Enter Application ID: ");

                    int applicationStudentId = InputUtil.readInt(
                            sc, "Enter Student ID: ");

                    int applicationCompanyId = InputUtil.readInt(
                            sc, "Enter Company ID: ");

                    applicationService.applyForCompany(
                            applicationId,
                            applicationStudentId,
                            applicationCompanyId,
                            studentService,
                            companyService);
                    break;
                }

                case 11:
                    applicationService.viewAllApplications();
                    break;

                case 12: {
                    int updateApplicationId = InputUtil.readInt(
                            sc, "Enter Application ID: ");

                    sc.nextLine();
                    System.out.print(
                            "Enter new status (Applied/Selected/Rejected): ");
                    String newStatus = sc.nextLine().trim();

                    applicationService.updateApplicationStatus(
                            updateApplicationId, newStatus);
                    break;
                }

                case 13: {
                    int applicationSearchStudentId = InputUtil.readInt(
                            sc, "Enter Student ID: ");

                    applicationService.viewApplicationsByStudent(
                            applicationSearchStudentId);
                    break;
                }

                case 14:
                    applicationService.displayPlacementStatistics();
                    break;

                case 15:
                    System.out.println(
                            "Exiting Student Placement Management System.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice! Please enter a number from 1 to 15.");
            }

        } while (choice != 15);

        sc.close();
    }
}
