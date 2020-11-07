package ru.croc.coder.dto;

/**
 * todo Document type SolutionDto
 */
public class SolutionDto {
    private Long id;

    private UserDto author;

    private ProblemDto problem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public ProblemDto getProblem() {
        return problem;
    }

    public void setProblem(ProblemDto problem) {
        this.problem = problem;
    }
}
