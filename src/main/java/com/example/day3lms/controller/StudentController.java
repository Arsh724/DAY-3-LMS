package com.example.day3lms.controller;

import com.example.day3lms.dto.StudentPatchDto;
import com.example.day3lms.dto.StudentRequestDto;
import com.example.day3lms.dto.StudentResponseDto;
import com.example.day3lms.service.StudentService;
import com.example.day3lms.model.StudentModel;
import com.example.day3lms.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class StudentController {
    private final StudentService service;
    private final JwtUtil jwtUtil;

    public StudentController(StudentService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    private void checkToken(String authHeader){
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Invalid Authorization token");
        }
        String token = authHeader.substring(7);
        jwtUtil.validateTokenAndGetEmail(token);
    }

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
    @PostMapping("/add-student")
    public StudentResponseDto addStudent(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody StudentRequestDto student){
        checkToken(authHeader);
        return service.addStudent(student);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(
            @RequestHeader(value = "Authorization", required = false) String authHeader
    ){
        checkToken(authHeader);
        return service.getStudents();
    }

    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable String id,
            @Valid  @RequestBody StudentRequestDto student){
        checkToken(authHeader);
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable String id){
        checkToken(authHeader);
        service.deleteStudent(id);
    }
}