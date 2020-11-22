package ru.croc.coder.dto;

import java.util.List;

public class ProblemsFileDto {
    private List<ProblemDto> problems;

    public List<ProblemDto> getProblems() {
        return problems;
    }

    public void setProblems(List<ProblemDto> problems) {
        this.problems = problems;
    }
}
