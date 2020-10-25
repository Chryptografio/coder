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
}
