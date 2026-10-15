
package com.placement.util;

public class ValidationUtil {

    public static boolean isValidStudentId(int studentId) {
        return studentId > 0;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidDepartment(String department) {
        return department != null
                && !department.trim().isEmpty();
    }

    public static boolean isValidCgpa(double cgpa) {
        return cgpa >= 0.0
                && cgpa <= 10.0
                && Double.isFinite(cgpa);
    }

    public static boolean isValidEmail(String email) {
        return email != null
                && email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        );
    }
}
