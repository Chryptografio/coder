package ru.croc.coder.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.croc.coder.dto.RegisterUserDto;
import ru.croc.coder.dto.UserDto;
import ru.croc.coder.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class RegisterController {

    private final UserService userService;

    @PostMapping
    public UserDto register(@RequestBody @Valid RegisterUserDto registerUserDto) {
        return userService.register(registerUserDto);
    }
}
