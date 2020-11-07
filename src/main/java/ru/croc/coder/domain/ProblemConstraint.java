package ru.croc.coder.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * todo Document type ProblemConstraint
 * @maxSize - allowed number of characters in the solution
 */
//@Entity
//@Table(name = "problem_constraints")
@Embeddable
public class ProblemConstraint {

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private Long maxTime;

    @Column
    private Long maxRAM;

    @Column
    private Long maxSize;

    @JoinColumn(name = "problem_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Problem problem;

    public LocalDate getStartDate() {
        return startDate;
    }

    public ProblemConstraint setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ProblemConstraint setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Long getMaxTime() {
        return maxTime;
    }

    public ProblemConstraint setMaxTime(Long maxTime) {
        this.maxTime = maxTime;
        return this;
    }

    public Long getMaxRAM() {
        return maxRAM;
    }

    public ProblemConstraint setMaxRAM(Long maxRAM) {
        this.maxRAM = maxRAM;
        return this;
    }

    public Long getMaxSize() {
        return maxSize;
    }

    public ProblemConstraint setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    public Problem getProblem() {
        return problem;
    }

    public ProblemConstraint setProblem(Problem problem) {
        this.problem = problem;
        return this;
    }
}
