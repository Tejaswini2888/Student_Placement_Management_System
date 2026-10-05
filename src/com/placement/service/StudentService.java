package com.placement.service;

import com.placement.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student>students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
