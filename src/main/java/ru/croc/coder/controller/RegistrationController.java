package ru.croc.coder.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.croc.coder.domain.User;
import ru.croc.coder.dto.RegisteringUserDto;
import ru.croc.coder.dto.UserDto;
import ru.croc.coder.service.UserService;

import javax.validation.Valid;

/**
 * todo Document type RegistrationController
 */
@RestController
@RequestMapping("user/registration")
public class RegistrationController {
    UserService userService;
    ModelMapper modelMapper;

    @Autowired
    public RegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public RegisteringUserDto showRegistrationForm() {
        return new RegisteringUserDto();
    }

    @PostMapping
    public UserDto registerNewUser(@RequestBody @Valid RegisteringUserDto newUser) {
        User user = userService.registerNewUser(newUser);
        return convertToDto(user);
    }

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
