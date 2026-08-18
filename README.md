# Project Title:

StudentHub — Student Management System

## 1. Project Description:

A Spring MVC web application to manage student records in colleges, schools, or training institutes. Built around a modern campus admin console visual identity, with a dashboard, full-text search, and a detailed record view in addition to standard CRUD.

Features:

- Dashboard with live stats (total students, departments, semesters, average CGPA) and a "recently added" feed
- Searchable student roster (search by name, roll number, or department)
- Add a new student
- Edit an existing student
- View a single student's full record (address, CGPA, contact info, etc.)
- Delete a student
- Avatar-initial badges generated automatically from each student's name

## 2. Tech Stack:

- Java 17
- Spring Boot 2.7.5
- Spring MVC
- Spring Data JPA / Hibernate
- Thymeleaf (with reusable fragments for navbar/footer)
- Custom CSS design system (no Bootstrap) — Poppins, Inter & JetBrains Mono via Google Fonts, indigo/violet gradient theme
- Maven
- MySQL database

## 3. Project Structure:

```
src/main/java/com/studentmanagementsystem/
├── controller/StudentController.java
├── model/Student.java
├── repository/StudentRepository.java
├── service/StudentService.java
├── service/StudentServiceImpl.java
└── SpringBootStudentManagementSystemApplication.java

src/main/resources/
├── application.properties
├── static/css/style.css
└── templates/
    ├── fragments/navbar.html
    ├── fragments/footer.html
    ├── dashboard.html          ("/")
    ├── students.html           ("/students")
    ├── new_student.html        ("/students/new")
    ├── update_student.html     ("/students/edit/{id}")
    └── student_details.html    ("/students/view/{id}")
```

## 4. How To Use:

i. Create a database in MySQL named `student_db`

ii. Open the project in your preferred IDE (Eclipse / STS / IntelliJ) as a Maven project

iii. Update `src/main/resources/application.properties` with your MySQL username and password

iv. Run the project as a Spring Boot App (run `SpringBootStudentManagementSystemApplication.java`)

v. Hibernate will automatically create a table named `students`

vi. Open the web app at `localhost:8080/`

vii. Add, search, view, update and delete student records from the web app

## 5. Student Fields:

- Student Name
- Roll Number
- Department
- Semester
- Email
- Phone
- CGPA
- Address

## 6. Possible Extensions:

- Pagination on the roster page for large student lists
- A Department or Course entity with its own page, instead of free-text fields
- Attendance tracking linked to each student
- Login/role-based access (admin vs viewer)

Have fun building on top of this 😎
