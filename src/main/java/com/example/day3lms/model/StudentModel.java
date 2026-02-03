package com.example.day3lms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="student-data")
public class StudentModel {
    @Id
    private String id;

    private String name;
    private String email;
    private int age;

}
