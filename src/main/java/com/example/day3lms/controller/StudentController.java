package com.example.day3lms.controller;

import com.example.day3lms.model.StudentModel;
import com.example.day3lms.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create function API
    @PostMapping("add-student/")
    public StudentModel addStudent(@RequestBody StudentModel student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/students")
    public List<StudentModel> getStudents() {
        return studentService.getStudents();
    }

    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public StudentModel deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }
}