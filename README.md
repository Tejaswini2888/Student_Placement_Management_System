# Student Placement Management System

## Project Overview

The **Student Placement Management System** is a Java-based console application designed to simplify and manage the student placement process. It helps maintain student records, company details, placement applications, and student resumes through a menu-driven interface.

## Features

### Student Management
- Register new students.
- View, search, update, and delete student records.
- Validate student details and CGPA.

### Company Management
- Add, view, and search company details.
- Display eligible students based on company CGPA requirements.

### Placement Application Management
- Apply for company placement opportunities.
- Prevent duplicate applications.
- View all applications and applications by student.
- Update application status (Applied, Selected, Rejected).
- Generate placement statistics.

### Resume Management
- Add and view student resumes.
- Search resumes using Student ID.
- Check resume submission status.
- Update and delete resume records.
- Validate PDF file paths.

### Data Management
- Store records using text files.
- Load saved records when the application starts.
- Preserve data between application runs.

## Technologies Used

- Java
- JDK 26
- IntelliJ IDEA
- Git and GitHub

## Java Concepts Implemented

- Object-Oriented Programming (OOP)
- Classes and Objects
- Encapsulation
- Constructors and Methods
- ArrayList and Collections
- Exception Handling
- File Handling
- Input Validation
- Modular Programming using Packages

## Project Structure

```text
StudentPlacementManagementSystem/
│
├── src/
│   └── com.placement/
│       ├── model/
│       │   ├── Student.java
│       │   ├── Company.java
│       │   ├── PlacementApplication.java
│       │   └── Resume.java
│       │
│       ├── service/
│       │   ├── StudentService.java
│       │   ├── CompanyService.java
│       │   ├── PlacementApplicationService.java
│       │   └── ResumeService.java
│       │
│       ├── storage/
│       │   └── FileStorage.java
│       │
│       ├── util/
│       │   ├── InputUtil.java
│       │   └── ValidationUtil.java
│       │
│       └── Main.java
│
├── .gitignore
└── README.md
```

## How to Run

1. Install JDK 26 or a compatible JDK.
2. Open the project in IntelliJ IDEA.
3. Navigate to `Main.java`.
4. Run the `Main` class.
5. Select options from the menu to manage placement records.

## Data Storage

The application stores records in text files inside the `data` directory:

- `students.txt`
- `companies.txt`
- `applications.txt`
- `resumes.txt`

The application loads saved records whenever it starts.

## Future Enhancements

- Database integration using MySQL.
- Graphical User Interface (GUI).
- Student and administrator login authentication.
- Automated placement notifications.

## Author

Student Project
