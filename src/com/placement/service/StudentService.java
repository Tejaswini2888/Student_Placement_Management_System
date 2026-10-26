
package com.placement.service;

import com.placement.model.Student;
import com.placement.util.ValidationUtil;
import com.placement.storage.FileStorage;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public StudentService() {
        loadStudents();
    }

    // Load saved students when the service starts
    private void loadStudents() {
        List<String> records = FileStorage.loadRecords("students.txt");

        for (String record : records) {
            try {
                String[] data = record.split(",", -1);

                if (data.length != 5) {
                    continue;
                }

                Student student = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3]),
                        data[4]
                );

                if (ValidationUtil.isValidStudentId(student.getStudentId())
                        && isValidStudent(student)
                        && !studentIdExists(student.getStudentId())) {
                    students.add(student);
                }

            } catch (NumberFormatException e) {
                System.out.println("Skipping an invalid student record.");
            }
        }

        System.out.println("Student records loaded: " + students.size());
    }

    // Save all students to the file
    private void saveStudents() {
        List<String> records = new ArrayList<>();

        for (Student student : students) {
            records.add(
                    student.getStudentId() + ","
                            + student.getName() + ","
                            + student.getDepartment() + ","
                            + student.getCgpa() + ","
                            + student.getEmail()
            );
        }

        FileStorage.saveRecords("students.txt", records);
    }

    private boolean studentIdExists(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return true;
            }
        }
        return false;
    }

    // Register a student
    public void addStudent(Student student) {
        if (!ValidationUtil.isValidStudentId(student.getStudentId())) {
            System.out.println("Invalid student ID!");
            return;
        }

        if (!isValidStudent(student)) {
            return;
        }

        if (studentIdExists(student.getStudentId())) {
            System.out.println("Student ID already exists!");
            return;
        }

        students.add(student);
        saveStudents();
        System.out.println("Student added successfully!");
    }

    // Validate student details
    private boolean isValidStudent(Student student) {
        if (!ValidationUtil.isValidName(student.getName())) {
            System.out.println("Student name cannot be empty!");
            return false;
        }

        if (!ValidationUtil.isValidDepartment(student.getDepartment())) {
            System.out.println("Department cannot be empty!");
            return false;
        }

        if (!ValidationUtil.isValidCgpa(student.getCgpa())) {
            System.out.println("CGPA must be between 0 and 10!");
            return false;
        }

        if (!ValidationUtil.isValidEmail(student.getEmail())) {
            System.out.println("Please enter a valid email address!");
            return false;
        }

        return true;
    }

    // View all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            System.out.println("----------------------");
            student.displayStudent();
        }
    }

    // Search a student
    public boolean searchStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println("Student found!");
                student.displayStudent();
                return true;
            }
        }

        System.out.println("Student not found.");
        return false;
    }

    // Update student details
    public void updateStudent(
            int studentId,
            String name,
            String department,
            double cgpa,
            String email) {

        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                Student updatedStudent = new Student(
                        studentId, name, department, cgpa, email
                );

                if (!isValidStudent(updatedStudent)) {
                    return;
                }

                student.setName(name);
                student.setDepartment(department);
                student.setCgpa(cgpa);
                student.setEmail(email);

                saveStudents();
                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete a student
    public void deleteStudent(int studentId) {
        boolean removed = students.removeIf(
                student -> student.getStudentId() == studentId
        );

        if (removed) {
            saveStudents();
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display students eligible for placement
    public void showEligibleStudents(double minimumCgpa) {
        boolean found = false;

        for (Student student : students) {
            if (student.getCgpa() >= minimumCgpa) {
                System.out.println("----------------------");
                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No eligible students found.");
        }
    }

    public boolean studentExists(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return true;
            }
        }
        return false;
    }

    public double getStudentCgpa(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student.getCgpa();
            }
        }
        return -1;
    }

}

