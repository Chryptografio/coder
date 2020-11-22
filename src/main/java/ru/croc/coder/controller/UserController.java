package ru.croc.coder.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.croc.coder.dto.UserDto;
import ru.croc.coder.service.UserService;

import java.util.Set;

/**
 * todo Document type UserController
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Set<UserDto> findAll() {
        return userService.list();
    }
}
