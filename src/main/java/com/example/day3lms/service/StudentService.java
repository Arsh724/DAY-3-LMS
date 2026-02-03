package com.example.day3lms.service;

import com.example.day3lms.dto.StudentRequestDto;
import com.example.day3lms.dto.StudentResponseDto;
import com.example.day3lms.exception.StudentNotFoundException;
import com.example.day3lms.model.StudentModel;
import com.example.day3lms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentResponseDto addStudent(StudentRequestDto dto) {
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

    public List<StudentResponseDto> getStudents() {
        return repository.findAll()
                .stream()
                .map(s -> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }

    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {
        StudentModel existing = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setEmail(dto.getEmail());

        StudentModel updated = repository.save(existing);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }

    public void deleteStudent(String id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Student Not Found");
        }
        repository.deleteById(id);
    }
}