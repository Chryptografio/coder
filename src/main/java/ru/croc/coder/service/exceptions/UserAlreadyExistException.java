package ru.croc.coder.service.exceptions;

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
