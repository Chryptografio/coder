package ru.croc.coder.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * todo Document type ProblemConstraint
 */
@Entity
@Table(name = "problem_constraints")
public class ProblemConstraint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String testClass;

    @Column(nullable = true)
    private LocalDate startDate;

    @Column(nullable = true)
    private LocalDate endDate;

    @Column(nullable = true)
    private Long maxTime;

    @Column(nullable = true)
    private Long maxRAM;

    @Column(nullable = true)
    private Long maxSize;

    @JoinColumn(name = "problem_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Problem problem;

    public Long getId() {
        return id;
    }

    public ProblemConstraint setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTestClass() {
        return testClass;
    }

    public ProblemConstraint setTestClass(String testClass) {
        this.testClass = testClass;
        return this;
    }

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
