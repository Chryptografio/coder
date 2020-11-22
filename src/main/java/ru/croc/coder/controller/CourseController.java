package ru.croc.coder.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.croc.coder.domain.Course;
import ru.croc.coder.dto.CourseDto;
import ru.croc.coder.service.CourseService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * todo Document type CourseController
 */
@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;

    private ModelMapper modelMapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_AUTHOR')")
    public List<CourseDto> getCourses() {
        return courseService.getCourses().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/available")
    @PreAuthorize("hasAnyRole('ROLE_AUTHOR', 'ROLE_STUDENT')")
    public List<CourseDto> getAvailableCourses() {
        return courseService.getAvailableCourses().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_AUTHOR')")
    public CourseDto createCourse(Authentication authentication, @RequestBody CourseDto courseDto) {
        String username = authentication.getName();
        return courseService.addCourse(username, courseDto);
    }

    @PostMapping("/{courseId}/enrollment")
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public CourseDto enrollToCourse(Authentication authentication, @PathVariable Long courseId) {
        String username = authentication.getName();
        return courseService.enrollStudentToCourse(username, courseId);
    }

    @PostMapping("/{courseId}/student/{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_AUTHOR')")
    public CourseDto addStudentToCourse(Authentication authentication, @PathVariable Long courseId, @PathVariable Long studentId) {
        String username = authentication.getName();
        return courseService.addStudentToCourse(username, courseId, studentId);
    }


    private CourseDto convertToDto(Course course) {
        return modelMapper.map(course, CourseDto.class);
    }
}
