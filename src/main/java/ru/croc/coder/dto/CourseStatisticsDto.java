package ru.croc.coder.dto;

import java.util.ArrayList;
import java.util.List;

public class CourseStatisticsDto {
    private Long numberOfProblems;

    private Long numberOfAttendees;

    private List<ProblemEntry> problemEntries = new ArrayList<>();

    public Long getNumberOfProblems() {
        return numberOfProblems;
    }

    public void setNumberOfProblems(Long numberOfProblems) {
        this.numberOfProblems = numberOfProblems;
    }

    public Long getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(Long numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public List<ProblemEntry> getProblemEntries() {
        return problemEntries;
    }

    public void setProblemEntries(List<ProblemEntry> problemEntries) {
        this.problemEntries = problemEntries;
    }
}

