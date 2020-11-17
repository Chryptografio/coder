package ru.croc.coder.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.croc.coder.domain.User;
import ru.croc.coder.dto.LoginUserDto;
import ru.croc.coder.dto.UserDto;
import ru.croc.coder.service.UserService;

import javax.validation.Valid;

/**
 * todo Document type LoginController
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    UserService userService;
    ModelMapper modelMapper;

    @Autowired
    public LoginController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public LoginUserDto showLoginForm() {
        return new LoginUserDto();
    }

    @PostMapping
    public UserDto loginUser(@RequestBody @Valid LoginUserDto loginUserDto) {
        User user = userService.loginUser(loginUserDto);
        return modelMapper.map(user, UserDto.class);
    }
}
