package com.example.day3lms.service;

import com.example.day3lms.model.StudentModel;
import com.example.day3lms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Create Student
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public StudentModel addStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    // Display Students
    public List<StudentModel> getStudents() {
        return studentRepository.findAll();
    }

    //Update
    public StudentModel updateStudent(String id, StudentModel student) {
        StudentModel existingStudent=studentRepository.findById(id).orElseThrow(() -> new RuntimeException("No Student found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());
        return studentRepository.save(existingStudent);
    }

    //Delete
    public void deleteStudent(String id) {
        StudentModel existingStudent =studentRepository.findById(id).orElseThrow(() -> new RuntimeException("No Student found"));
        studentRepository.deleteById(String.valueOf(existingStudent));
    }
}
