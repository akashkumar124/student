package com.akash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.model.Student;
import com.akash.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public Optional<Student> findByRollNumber(Integer rollNumber) {
        return studentRepository.findById(rollNumber);
    }
    
    public double getAveragePercentageForRecentSemester() {
        Iterable<Student> students = studentRepository.findAll();
        int totalMarks = 0;
        int count = 0;
        
        for (Student student : students) {
            int semester = student.getRecentSemester();
            if (semester != -1) {
                totalMarks += student.getTotalMarksForSemester(semester);
                count++;
            }
        }
        
        if (count == 0) {
            return -1;
        } else {
            return (totalMarks / (count * 3.0)) * 100;
        }
    }
    
    public double getAverageMarksForSubject(String subject) {
        double totalMarks = 0;
        int count = 0;
        Iterable<Student> students = studentRepository.findAll();
        
        for (Student student : students) {
            int marks = student.getMarksForSubject(subject);
            if (marks != -1) {
                totalMarks += marks;
                count++;
            }
        }
        
        if (count == 0) {
            return -1;
        } else {
            return totalMarks / count;
        }
    }
    
    public List<Student> getTopTwoConsistentStudents() {
        Iterable<Student> students = studentRepository.findAll();
        List<Student> topTwoStudents = new ArrayList<>();
        double maxAverage = 0;
        double secondMaxAverage = 0;
        
        for (Student student : students) {
            double average = student.getAverageMarks();
            if (average >= maxAverage) {
                secondMaxAverage = maxAverage;
                maxAverage = average;
                topTwoStudents.add(0, student);
                
                if (topTwoStudents.size() > 2) {
                    topTwoStudents.remove(2);
                }
            } else if (average >= secondMaxAverage) {
                secondMaxAverage = average;
                topTwoStudents.add(1, student);
                
                if (topTwoStudents.size() > 2) {
                    topTwoStudents.remove(2);
                }
            }
        }
        
        return topTwoStudents;
    }
    
    
}




