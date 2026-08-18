package com.studentmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentmanagementsystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByStudentNameContainingIgnoreCaseOrRollNumberContainingIgnoreCaseOrDepartmentContainingIgnoreCase(
            String studentName, String rollNumber, String department);

    @Query("SELECT COUNT(DISTINCT s.department) FROM Student s")
    long countDistinctDepartments();

    @Query("SELECT COUNT(DISTINCT s.semester) FROM Student s")
    long countDistinctSemesters();

    @Query("SELECT AVG(s.cgpa) FROM Student s")
    Double averageCgpa();
}
