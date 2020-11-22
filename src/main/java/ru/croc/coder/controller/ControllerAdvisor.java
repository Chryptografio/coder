package ru.croc.coder.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.croc.coder.dto.ExceptionDto;
import ru.croc.coder.service.exception.UserAlreadyExistException;

import java.util.Collections;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistException e, WebRequest webRequest) {
        return handleExceptionInternal(
            e,
            new ExceptionDto(
                e.getClass().getName(),
                e.getMessage(),
                Collections.singletonMap("SessionId", webRequest.getSessionId())),
            new HttpHeaders(),
            HttpStatus.BAD_REQUEST,
            webRequest);
    }
}