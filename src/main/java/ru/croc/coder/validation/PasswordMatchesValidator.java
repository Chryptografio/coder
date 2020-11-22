package ru.croc.coder.validation;

import ru.croc.coder.annotation.PasswordMatches;
import ru.croc.coder.dto.RegisterUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        //no need to initialize
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        RegisterUserDto userDto = (RegisterUserDto) value;
        return userDto.getPassword().equals(userDto.getMatchingPassword());
    }
}