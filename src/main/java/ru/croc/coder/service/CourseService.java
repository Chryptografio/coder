package ru.croc.coder.service;

import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Course;
import ru.croc.coder.domain.User;
import ru.croc.coder.repository.CourseRepository;
import ru.croc.coder.repository.UserRepository;
import ru.croc.coder.service.exceptions.NotFoundException;

/**
 * todo Document type CourseService
 */
@Service
public class CourseService {
    private CourseRepository courseRepository;

    private UserRepository userRepository;

    public Course publishCourse(Long userId, String description) {
        User user = userRepository.findById(userId)
            .orElseThrow(NotFoundException::new);

        Course course = new Course()
            .setAuthor(user)
            .setDescription(description);

        return courseRepository.save(course);
    }
}
