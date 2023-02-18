package com.akash.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Semester {
    private int semesterNumber;

    private List<Marks> subjectMarks = new ArrayList<>();

    // Constructors, getters, and setters
}
