package com.akash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(indexName = "students")
public class Student {
    @Id
    private Integer id;

    private String name;

    private String rollNumber;

    private List<Semester> semesters = new ArrayList<>();

    // Constructors, getters, and setters
}

