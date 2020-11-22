package ru.croc.coder.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.croc.coder.dto.CourseDto;
import ru.croc.coder.dto.UserDto;
import ru.croc.coder.service.UserService;

import java.util.List;
import java.util.Set;

/**
 * todo Document type UserController
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public Set<UserDto> findAll() {
        return userService.list();
    }

    @GetMapping("/me")
    public UserDto getUserInformation(Authentication authentication) {
        String username = authentication.getName();
        log.info("authDetails: {}", username);
        UserDto userDto = userService.getUser(username);
        log.info("UserDto: {}", userDto.getFirstName());
        return userDto;
    }

    @GetMapping("/me/attendedCourses")
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public List<CourseDto> getAttendedCourses(Authentication authentication) {
        String username = authentication.getName();

        return userService.getAttendedCourses(username);
    }
}
