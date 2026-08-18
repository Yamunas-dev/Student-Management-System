package com.studentmanagementsystem.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.model.Student;
import com.studentmanagementsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> searchStudents(String keyword) {
		if (keyword == null || keyword.trim().isEmpty()) {
			return getAllStudents();
		}
		return studentRepository
				.findByStudentNameContainingIgnoreCaseOrRollNumberContainingIgnoreCaseOrDepartmentContainingIgnoreCase(
						keyword, keyword, keyword);
	}

	@Override
	public List<Student> getRecentStudents(int limit) {
		return studentRepository.findAll().stream()
				.sorted(Comparator.comparingLong(Student::getId).reversed())
				.limit(limit)
				.collect(Collectors.toList());
	}

	@Override
	public void saveStudent(Student student) {
		this.studentRepository.save(student);
	}

	@Override
	public Student getStudentById(long id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student;
		if (optional.isPresent()) {
			student = optional.get();
		} else {
			throw new RuntimeException(" Student not found for id :: " + id);
		}
		return student;
	}

	@Override
	public void deleteStudentById(long id) {
		this.studentRepository.deleteById(id);
	}

	@Override
	public long countTotalStudents() {
		return studentRepository.count();
	}

	@Override
	public long countDistinctDepartments() {
		return studentRepository.countDistinctDepartments();
	}

	@Override
	public long countDistinctSemesters() {
		return studentRepository.countDistinctSemesters();
	}

	@Override
	public double getAverageCgpa() {
		Double avg = studentRepository.averageCgpa();
		return avg != null ? avg : 0.0;
	}

}
