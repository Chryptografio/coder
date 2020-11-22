package ru.croc.coder.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Course;
import ru.croc.coder.domain.Role;
import ru.croc.coder.domain.User;
import ru.croc.coder.dto.CourseDto;
import ru.croc.coder.repository.CourseRepository;
import ru.croc.coder.repository.UserRepository;
import ru.croc.coder.service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * todo Document type CourseService
 */
@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<Course> getCourses() {
        return (ArrayList<Course>) courseRepository.findAll();
    }

    public List<Course> getAvailableCourses() {

        return ((ArrayList<Course>) courseRepository.findAll()).stream()
            .filter(course -> true) // TODO change
            .collect(Collectors.toList());
    }

    public CourseDto addCourse(String authorUsername, CourseDto courseDto) {
        User user = userRepository.findByEmail(authorUsername).orElseThrow(NotFoundException::new);

        if (!user.getRole().equals(Role.AUTHOR)) {
            throw new NotFoundException();
        }

        Course course = new Course()
            .setAuthor(user)
            .setName(courseDto.getName())
            .setDescription(courseDto.getDescription());

        return modelMapper.map(courseRepository.save(course), CourseDto.class);
    }
}
