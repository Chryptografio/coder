package ru.croc.coder.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Availability;
import ru.croc.coder.domain.Course;
import ru.croc.coder.domain.Role;
import ru.croc.coder.domain.User;
import ru.croc.coder.dto.CourseDto;
import ru.croc.coder.dto.CourseStatisticsDto;
import ru.croc.coder.repository.CourseRepository;
import ru.croc.coder.repository.SolutionRepository;
import ru.croc.coder.repository.UserRepository;
import ru.croc.coder.service.exception.NotAllowedOperationException;
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
            .filter(course -> course.getAvailability().equals(Availability.OPEN))
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
            .setDescription(courseDto.getDescription())
            .setAvailability(courseDto.getAvailability());

        return modelMapper.map(courseRepository.save(course), CourseDto.class);
    }

    public CourseDto enrollStudentToCourse(String username, Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundException::new);
        User user = userRepository.findByEmail(username).orElseThrow(NotFoundException::new);

        if (course.getAvailability().equals(Availability.CLOSED)) {
            throw new NotAllowedOperationException();
        }

        // TODO add endpoint attended courses
        user.getAttendedCourses().add(course);
        userRepository.save(user);

        return modelMapper.map(course, CourseDto.class);
    }

    public CourseDto addStudentToCourse(String username, Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundException::new);
        User user = userRepository.findByEmail(username).orElseThrow(NotFoundException::new);
        User student = userRepository.findById(studentId).orElseThrow(NotFoundException::new);

        if (!course.getAuthor().equals(user) || student.getRole().equals(Role.AUTHOR) || student.getAttendedCourses().contains(course)) {
            throw new NotAllowedOperationException();
        }

        student.getAttendedCourses().add(course);
        userRepository.save(student);

        return modelMapper.map(course, CourseDto.class);
    }

    public CourseStatisticsDto getCourseStatistics(String username, Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundException::new);
        User user = userRepository.findByEmail(username).orElseThrow(NotFoundException::new);

        if (!course.getAuthor().equals(user)) {
            throw new NotAllowedOperationException();
        }

        CourseStatisticsDto statistics = new CourseStatisticsDto();
        statistics.setNumberOfProblems((long) course.getProblems().size());
        statistics.setNumberOfAttendees((long) course.getAttendees().size());

        return statistics;
    }
}
