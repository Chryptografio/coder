package ru.croc.coder.domain;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Solution)) {
            return false;
        }
        Solution solution1 = (Solution) o;
        return getId().equals(solution1.getId()) &&
            getSolution().equals(solution1.getSolution()) &&
            getAuthor().equals(solution1.getAuthor()) &&
            getProblem().equals(solution1.getProblem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSolution(), getAuthor(), getProblem());
    }
}
