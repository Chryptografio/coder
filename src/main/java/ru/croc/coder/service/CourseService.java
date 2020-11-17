package ru.croc.coder.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Course;
import ru.croc.coder.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * todo Document type CourseService
 */
@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;

    public List<Course> getCourses() {
        return (ArrayList<Course>) courseRepository.findAll();
    }

    public List<Course> getAvailableCourses() {

        return ((ArrayList<Course>) courseRepository.findAll()).stream()
            .filter(course -> true) // TODO change
            .collect(Collectors.toList());
    }
}
