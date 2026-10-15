
package com.placement;

import com.placement.model.Student;
import com.placement.model.Company;
import com.placement.service.StudentService;
import com.placement.service.CompanyService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CompanyService companyService = new CompanyService();

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
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    Student student = new Student(
                            studentId, name, department, cgpa, email
                    );

                    studentService.addStudent(student);
                    break;

                case 2:
                    studentService.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    studentService.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    System.out.print("Enter New CGPA: ");
                    double newCgpa = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    studentService.updateStudent(
                            updateId, newName, newDepartment,
                            newCgpa, newEmail
                    );
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    studentService.deleteStudent(deleteId);
                    break;

                case 6:
                    System.out.print("Enter Company ID: ");
                    int companyId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Company Name: ");
                    String companyName = sc.nextLine();

                    System.out.print("Enter Job Role: ");
                    String jobRole = sc.nextLine();

                    System.out.print("Enter Package (LPA): ");
                    double packageLpa = sc.nextDouble();

                    System.out.print("Enter Minimum CGPA: ");
                    double minimumCgpa = sc.nextDouble();
                    sc.nextLine();

                    Company company = new Company(
                            companyId, companyName, jobRole,
                            packageLpa, minimumCgpa
                    );

                    companyService.addCompany(company);
                    break;

                case 7:
                    companyService.viewAllCompanies();
                    break;

                case 8:
                    System.out.print("Enter Company ID to search: ");
                    int searchCompanyId = sc.nextInt();

                    companyService.searchCompany(searchCompanyId);
                    break;

                case 9:
                    System.out.println("Exiting Student Placement Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1 to 9.");
            }

        } while (choice != 9);

        sc.close();
    }
}

