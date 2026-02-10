package com.example.day3lms.controller;

import com.example.day3lms.dto.*;
import com.example.day3lms.model.StudentModel;
import com.example.day3lms.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    /* ---------- POST ---------- */
    @PostMapping
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto dto) {
        return service.addStudent(dto);
    }

    /* ---------- GET ---------- */
    @GetMapping
    public List<StudentResponseDto> getStudents() {
        return service.getStudents();
    }

    /* ---------- PATCH ---------- */
    @PatchMapping("/{id}")
    public StudentResponseDto patchStudent(
            @PathVariable String id,
            @RequestBody StudentPatchDto dto
    ) {
        StudentModel updated = service.patchStudent(id, dto);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }

    /* ---------- PUT ---------- */
    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable String id,
            @RequestBody StudentRequestDto dto
    ) {
        return service.updateStudent(id, dto);
    }

    /* ---------- DELETE ---------- */
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
    }
}
