package com.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagementsystem.model.Student;
import com.studentmanagementsystem.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("totalStudents", studentService.countTotalStudents());
        model.addAttribute("totalDepartments", studentService.countDistinctDepartments());
        model.addAttribute("totalSemesters", studentService.countDistinctSemesters());
        model.addAttribute("averageCgpa", studentService.getAverageCgpa());
        model.addAttribute("recentStudents", studentService.getRecentStudents(5));
        return "dashboard";
    }

    @GetMapping("/students")
    public String listStudents(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        model.addAttribute("listStudents", studentService.searchStudents(keyword));
        model.addAttribute("keyword", keyword);
        return "students";
    }

    @GetMapping("/students/new")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/students/view/{id}")
    public String viewStudent(@PathVariable(value = "id") long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student_details";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id) {
        this.studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
