
package com.placement;

import com.placement.model.Student;
import com.placement.model.Company;
import com.placement.model.Resume;

import com.placement.service.StudentService;
import com.placement.service.CompanyService;
import com.placement.service.PlacementApplicationService;
import com.placement.service.ResumeService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CompanyService companyService = new CompanyService();
        PlacementApplicationService applicationService =
                new PlacementApplicationService();
        ResumeService resumeService = new ResumeService();

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println(" STUDENT PLACEMENT MANAGEMENT SYSTEM");
            System.out.println("======================================");

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
            System.out.println("15. Resume Management");
            System.out.println("16. Exit");

            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1: {
                    System.out.print("Enter Student ID: ");
                    int studentId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter CGPA: ");
                    double cgpa = Double.parseDouble(sc.nextLine());

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    Student student = new Student(
                            studentId, name, department, cgpa, email
                    );

                    studentService.addStudent(student);
                    break;
                }

                case 2:
                    studentService.viewAllStudents();
                    break;

                case 3: {
                    System.out.print("Enter Student ID to search: ");
                    int id = Integer.parseInt(sc.nextLine());

                    studentService.searchStudent(id);
                    break;
                }

                case 4: {
                    System.out.print("Enter Student ID to update: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    System.out.print("Enter New CGPA: ");
                    double newCgpa = Double.parseDouble(sc.nextLine());

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    studentService.updateStudent(
                            updateId,
                            newName,
                            newDepartment,
                            newCgpa,
                            newEmail
                    );
                    break;
                }

                case 5: {
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    studentService.deleteStudent(deleteId);
                    break;
                }

                case 6: {
                    System.out.print("Enter Company ID: ");
                    int companyId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Company Name: ");
                    String companyName = sc.nextLine();

                    System.out.print("Enter Job Role: ");
                    String jobRole = sc.nextLine();

                    System.out.print("Enter Package (LPA): ");
                    double packageLpa =
                            Double.parseDouble(sc.nextLine());

                    System.out.print("Enter Minimum CGPA: ");
                    double minimumCgpa =
                            Double.parseDouble(sc.nextLine());

                    Company company = new Company(
                            companyId,
                            companyName,
                            jobRole,
                            packageLpa,
                            minimumCgpa
                    );

                    companyService.addCompany(company);
                    break;
                }

                case 7:
                    companyService.viewAllCompanies();
                    break;

                case 8: {
                    System.out.print("Enter Company ID to search: ");
                    int companyId = Integer.parseInt(sc.nextLine());

                    companyService.searchCompany(companyId);
                    break;
                }

                case 9: {
                    System.out.print("Enter Company ID: ");
                    int eligibleCompanyId =
                            Integer.parseInt(sc.nextLine());

                    companyService.showEligibleStudents(
                            eligibleCompanyId,
                            studentService
                    );
                    break;
                }

                case 10: {
                    System.out.print("Enter Application ID: ");
                    int applicationId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Student ID: ");
                    int applicationStudentId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Company ID: ");
                    int applicationCompanyId =
                            Integer.parseInt(sc.nextLine());

                    applicationService.applyForCompany(
                            applicationId,
                            applicationStudentId,
                            applicationCompanyId,
                            studentService,
                            companyService
                    );
                    break;
                }

                case 11:
                    applicationService.viewAllApplications();
                    break;

                case 12: {
                    System.out.print("Enter Application ID: ");
                    int applicationId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Enter New Status (Applied/Selected/Rejected): "
                    );
                    String newStatus = sc.nextLine();

                    applicationService.updateApplicationStatus(
                            applicationId,
                            newStatus
                    );
                    break;
                }

                case 13: {
                    System.out.print("Enter Student ID: ");
                    int studentId = Integer.parseInt(sc.nextLine());

                    applicationService.viewApplicationsByStudent(
                            studentId
                    );
                    break;
                }

                case 14:
                    applicationService.displayPlacementStatistics();
                    break;

                case 15: {

                    int resumeChoice;

                    do {
                        System.out.println("\n================================");
                        System.out.println("       RESUME MANAGEMENT");
                        System.out.println("================================");

                        System.out.println("1. Add Student Resume");
                        System.out.println("2. View All Resumes");
                        System.out.println("3. Search Resume by Student ID");
                        System.out.println("4. Check Resume Submission Status");
                        System.out.println("5. Update Student Resume");
                        System.out.println("6. Delete Student Resume");
                        System.out.println("7. Back to Main Menu");

                        System.out.print("\nEnter your choice: ");
                        resumeChoice =
                                Integer.parseInt(sc.nextLine());

                        switch (resumeChoice) {

                            case 1: {
                                System.out.print("Enter Student ID: ");
                                int id = Integer.parseInt(sc.nextLine());

                                if (!studentService.studentExists(id)) {
                                    System.out.println(
                                            "Student is not registered!"
                                    );
                                    break;
                                }

                                String studentId = String.valueOf(id);

                                if (resumeService.hasResume(studentId)) {
                                    System.out.println(
                                            "Resume already submitted!"
                                    );
                                    break;
                                }

                                System.out.print("Enter Email: ");
                                String email = sc.nextLine();

                                System.out.print("Enter Education Details: ");
                                String education = sc.nextLine();

                                System.out.print("Enter Skills: ");
                                String skills = sc.nextLine();

                                System.out.print("Enter Projects: ");
                                String projects = sc.nextLine();

                                System.out.print("Enter Certifications: ");
                                String certifications = sc.nextLine();

                                System.out.print(
                                        "Enter Resume PDF File Path: "
                                );
                                String filePath = sc.nextLine();

                                if (!resumeService.isValidPdf(filePath)) {
                                    System.out.println(
                                            "Resume submission cancelled!"
                                    );
                                    break;
                                }

                                Resume resume = new Resume(
                                        studentId,
                                        email,
                                        education,
                                        skills,
                                        projects,
                                        certifications,
                                        filePath.trim()
                                );

                                resumeService.addResume(resume);
                                break;
                            }

                            case 2:
                                resumeService.viewAllResumes();
                                break;

                            case 3: {
                                System.out.print("Enter Student ID: ");
                                String studentId = sc.nextLine();

                                Resume resume =
                                        resumeService.getResumeByStudentId(
                                                studentId
                                        );

                                if (resume != null) {
                                    resume.displayResume();
                                } else {
                                    System.out.println("Resume not found!");
                                }
                                break;
                            }

                            case 4: {
                                System.out.print("Enter Student ID: ");
                                String studentId = sc.nextLine();

                                if (resumeService.hasResume(studentId)) {
                                    System.out.println(
                                            "Resume has been submitted."
                                    );
                                } else {
                                    System.out.println(
                                            "Resume has not been submitted."
                                    );
                                }
                                break;
                            }

                            case 5: {
                                System.out.print("Enter Student ID: ");
                                String studentId = sc.nextLine();

                                if (!resumeService.hasResume(studentId)) {
                                    System.out.println("Resume not found!");
                                    break;
                                }

                                System.out.print("Enter Email: ");
                                String email = sc.nextLine();

                                System.out.print("Enter Education Details: ");
                                String education = sc.nextLine();

                                System.out.print("Enter Skills: ");
                                String skills = sc.nextLine();

                                System.out.print("Enter Projects: ");
                                String projects = sc.nextLine();

                                System.out.print("Enter Certifications: ");
                                String certifications = sc.nextLine();

                                System.out.print(
                                        "Enter New Resume PDF File Path: "
                                );
                                String filePath = sc.nextLine();

                                if (!resumeService.isValidPdf(filePath)) {
                                    System.out.println(
                                            "Resume update cancelled!"
                                    );
                                    break;
                                }

                                Resume updatedResume = new Resume(
                                        studentId,
                                        email,
                                        education,
                                        skills,
                                        projects,
                                        certifications,
                                        filePath.trim()
                                );

                                resumeService.updateResume(
                                        studentId,
                                        updatedResume
                                );
                                break;
                            }

                            case 6: {
                                System.out.print(
                                        "Enter Student ID to delete resume: "
                                );
                                String studentId = sc.nextLine();

                                if (!resumeService.hasResume(studentId)) {
                                    System.out.println("Resume not found!");
                                    break;
                                }

                                System.out.print(
                                        "Are you sure you want to delete "
                                                + "this resume? (yes/no): "
                                );

                                String confirmation = sc.nextLine();

                                if (confirmation.equalsIgnoreCase("yes")) {
                                    resumeService.deleteResume(studentId);
                                } else {
                                    System.out.println(
                                            "Resume deletion cancelled!"
                                    );
                                }
                                break;
                            }

                            case 7:
                                System.out.println(
                                        "Returning to Main Menu..."
                                );
                                break;

                            default:
                                System.out.println(
                                        "Invalid Resume Management choice!"
                                );
                        }

                    } while (resumeChoice != 7);

                    break;
                }

                case 16:
                    System.out.println(
                            "Thank you for using Student Placement Management System!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 16);

        sc.close();
    }
}
