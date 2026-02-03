package com.example.day3lms.controller;

import com.example.day3lms.dto.StudentRequestDto;
import com.example.day3lms.dto.StudentResponseDto;
import com.example.day3lms.model.StudentModel;
import com.example.day3lms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto dto) {
        return service.addStudent(dto);
    }

    @GetMapping
    public List<StudentResponseDto> getStudents() {
        return service.getStudents();
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id,
                                            @Valid @RequestBody StudentRequestDto dto) {
        return service.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "Deleted";
    }
}