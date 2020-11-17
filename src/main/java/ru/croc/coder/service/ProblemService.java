package ru.croc.coder.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Course;
import ru.croc.coder.domain.Problem;
import ru.croc.coder.repository.CourseRepository;
import ru.croc.coder.repository.ProblemRepository;
import ru.croc.coder.service.exception.NotFoundException;

@Service
@AllArgsConstructor
public class ProblemService {
    private CourseRepository courseRepository;

    private ProblemRepository problemRepository;

    public Problem publishProblem(Long courseId, Problem problem) {
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundException::new);

        problem.setCourse(course);

        return problemRepository.save(problem);
    }
}
