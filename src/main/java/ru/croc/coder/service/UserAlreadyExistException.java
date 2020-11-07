package ru.croc.coder.service;

/**
 * todo Document type UserAlreadyExistException
 */
public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
