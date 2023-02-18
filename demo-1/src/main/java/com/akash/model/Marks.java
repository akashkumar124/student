package com.akash.model;

import java.util.List;

import lombok.Data;

@Data
public class Marks {
	
	private String subject;

    private int marks;
    
 // Implementation of getTotalMarksForSemester() method in Student class
    public int getTotalMarksForSemester(int semester) {
        int totalMarks = 0;
        List<Marks> marksList = this.getMarksForSemester(semester);
        for (Marks marks : marksList) {
            totalMarks += marks.getTotalMarks();
        }
        return totalMarks;
    }

    // Implementation of getRecentSemester() method in Student class
    public int getRecentSemester() {
        int recentSemester = 1;
        for (Marks marks : this.marks) {
            if (marks.getSemester() > recentSemester) {
                recentSemester = marks.getSemester();
            }
        }
        return recentSemester;
    }

    // Implementation of getMarksForSubject() method in Student class
    public int getMarksForSubject(String subject, int semester) {
        for (Marks marks : this.marks) {
            if (marks.getSubject().equals(subject) && marks.getSemester() == semester) {
                return marks.getMarksObtained();
            }
        }
        return -1;
    }


}
