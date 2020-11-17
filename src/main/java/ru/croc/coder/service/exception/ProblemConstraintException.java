package ru.croc.coder.service.exception;

public class ProblemConstraintException extends RuntimeException {
    public ProblemConstraintException() {
        super();
    }

    public ProblemConstraintException(String message) {
        super(message);
    }
}
