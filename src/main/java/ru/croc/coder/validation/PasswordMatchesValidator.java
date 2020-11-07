package ru.croc.coder.validation;

import ru.croc.coder.annotation.PasswordMatches;
import ru.croc.coder.dto.RegisteringUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * todo Document type PasswordMatchesValidator
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        //no need to initialize
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        RegisteringUserDto userDto = (RegisteringUserDto) value;
        return userDto.getPassword().equals(userDto.getMatchingPassword());
    }
}
