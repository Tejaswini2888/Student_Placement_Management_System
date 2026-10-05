package com.placement.model;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String branch;
    private double cgpa;
    private String email;
    private String skills;

    public Student(int studentId, String name, int age, String branch,
                   double cgpa, String email, String skills) {

        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.branch = branch;
        this.cgpa = cgpa;
        this.email = email;
        this.skills = skills;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", branch='" + branch + '\'' +
                ", cgpa=" + cgpa +
                ", email='" + email + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
