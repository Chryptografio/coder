package ru.croc.coder.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * todo Document type Problem
 */
@Entity
@Table(name = "problems")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Lob
    private String template;

    @Lob
    private String referenceSolution;

    @OneToOne(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
    private ProblemConstraint problemConstraint;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private Set<Solution> solutions;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InputOutput> data = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Problem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Problem setDescription(String description) {
        this.description = description;
        return this;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Problem setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public Problem setTemplate(String template) {
        this.template = template;
        return this;
    }

    public String getReferenceSolution() {
        return referenceSolution;
    }

    public Problem setReferenceSolution(String referenceSolution) {
        this.referenceSolution = referenceSolution;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Problem setCourse(Course course) {
        this.course = course;
        return this;
    }

    public ProblemConstraint getProblemConstraint() {
        return problemConstraint;
    }

    public Problem setProblemConstraint(ProblemConstraint problemConstraint) {
        this.problemConstraint = problemConstraint;
        return this;
    }

    public Set<Solution> getSolutions() {
        return solutions;
    }

    public Problem setSolutions(Set<Solution> solutions) {
        //clear existing children list so that they are removed from database
        this.solutions.clear();
        //add the new children list created above to the existing list
        this.solutions.addAll(solutions);
        return this;
    }

    public Set<InputOutput> getData() {
        return data;
    }

    public Problem setData(Set<InputOutput> data) {
        this.data = data;
        return this;
    }
}
