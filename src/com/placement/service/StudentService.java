
package com.placement.service;

import com.placement.model.Student;
import com.placement.util.ValidationUtil;
import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    // Register student
    public void addStudent(Student student) {

        if (!ValidationUtil.isValidStudentId(student.getStudentId())) {
            System.out.println("Invalid student ID!");
            return;
        }

        if (!isValidStudent(student)) {
            return;
        }

        for (Student existing : students) {
            if (existing.getStudentId() == student.getStudentId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
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

    // Search student
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

    // Update student
    public void updateStudent(int studentId, String name,
                              String department, double cgpa,
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

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete student
    public void deleteStudent(int studentId) {

        boolean removed = students.removeIf(
                student -> student.getStudentId() == studentId
        );

        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}

