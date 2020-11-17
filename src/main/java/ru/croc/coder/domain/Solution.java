package ru.croc.coder.domain;

import javax.persistence.*;

/**
 * todo Document type Solution
 */
@Entity
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String solution;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    public Long getId() {
        return id;
    }

    public Solution setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSolution() {
        return solution;
    }

    public Solution setSolution(String solution) {
        this.solution = solution;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Solution setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Problem getProblem() {
        return problem;
    }

    public Solution setProblem(Problem problem) {
        this.problem = problem;
        return this;
    }
}
