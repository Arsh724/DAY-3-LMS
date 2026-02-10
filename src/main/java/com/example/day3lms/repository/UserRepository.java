package com.example.day3lms.repository;

import com.example.day3lms.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel, String> {

    Optional<UserModel> findByEmail(String email);
}
