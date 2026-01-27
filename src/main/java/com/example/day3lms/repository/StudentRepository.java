package com.example.day3lms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.day3lms.model.StudentModel;

public interface StudentRepository extends MongoRepository<StudentModel, String> {

}
