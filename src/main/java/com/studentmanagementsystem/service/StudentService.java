package com.studentmanagementsystem.service;

import java.util.List;

import com.studentmanagementsystem.model.Student;

public interface StudentService {
	List<Student> getAllStudents();
	List<Student> searchStudents(String keyword);
	List<Student> getRecentStudents(int limit);
	void saveStudent(Student student);
	Student getStudentById(long id);
	void deleteStudentById(long id);
	long countTotalStudents();
	long countDistinctDepartments();
	long countDistinctSemesters();
	double getAverageCgpa();
}
