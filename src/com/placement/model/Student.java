
package com.placement.model;

public class Student {

    private int studentId;
    private String name;
    private String department;
    private double cgpa;
    private String email;

    // Constructor
    public Student(int studentId, String name,
                   String department, double cgpa,
                   String email) {

        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
        this.email = email;
    }

    // Getter methods
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Display student details
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Email: " + email);
    }
}

