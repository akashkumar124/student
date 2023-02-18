package com.akash.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.akash.model.Student;

public interface StudentRepository extends ElasticsearchRepository<Student, Integer> {
    List<Student> findByName(String name);
    Optional<Student> findByRollNumber(String rollNumber);
}
