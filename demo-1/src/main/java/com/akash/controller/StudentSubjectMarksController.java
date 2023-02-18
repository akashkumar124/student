package com.akash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.akash.model.StudentSubjectMarks;
import com.akash.service.StudentSubjectMarksService;

import java.util.List;

@RestController
@RequestMapping("/student-marks")
public class StudentSubjectMarksController {

    @Autowired
    private StudentSubjectMarksService service;

    @PostMapping
    public void addOrUpdateStudentSubjectMarks(@RequestBody StudentSubjectMarks studentSubjectMarks) {
        service.addOrUpdateStudentSubjectMarks(studentSubjectMarks);
    }

    @GetMapping("/{studentId}")
    public List<StudentSubjectMarks> getStudentSubjectMarksByStudentId(@PathVariable Long studentId) {
        return service.getStudentSubjectMarksByStudentId(studentId);
    }

    @GetMapping
    public List<StudentSubjectMarks> getStudentSubjectMarksBySemesterAndSubject(@RequestParam Integer semester, @RequestParam String subject) {
        return service.getStudentSubjectMarksBySemesterAndSubject(semester, subject);
    }

    @GetMapping("/average-marks")
    public double getAverageMarksBySemesterAndSubject(@RequestParam Integer semester, @RequestParam String subject) {
        return service.getAverageMarksOfSubjectBySemester(semester, subject);
    }

    @GetMapping("/average-percentage")
    public double getAveragePercentageBySemester(@RequestParam Integer semester) {
        return service.getAveragePercentageOfWholeClassBySemester(semester);
    }

    @GetMapping("/top-two-students")
    public List<StudentSubjectMarks> getTopTwoConsistentStudents() {
        return service.getTopTwoConsistentStudents();
    }
}

