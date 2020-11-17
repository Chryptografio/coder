package ru.croc.coder.dto;

import ru.croc.coder.domain.Difficulty;

/**
 * todo Document type ProblemDto
 */
public class ProblemDto {
    private Long id;

    private String description;

    private Difficulty difficulty;

    private String template;

    private String referenceSolution;

    private String testClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getReferenceSolution() {
        return referenceSolution;
    }

    public void setReferenceSolution(String referenceSolution) {
        this.referenceSolution = referenceSolution;
    }

    public String getTestClass() {
        return testClass;
    }

    public void setTestClass(String testClass) {
        this.testClass = testClass;
    }
}
