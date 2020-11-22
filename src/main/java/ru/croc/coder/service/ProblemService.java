package ru.croc.coder.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Course;
import ru.croc.coder.domain.Problem;
import ru.croc.coder.domain.User;
import ru.croc.coder.dto.ProblemDto;
import ru.croc.coder.repository.CourseRepository;
import ru.croc.coder.repository.ProblemRepository;
import ru.croc.coder.repository.UserRepository;
import ru.croc.coder.service.exception.NotAllowedOperationException;
import ru.croc.coder.service.exception.NotFoundException;

@Service
@AllArgsConstructor
public class ProblemService {

    private final CourseRepository courseRepository;
    private final ProblemRepository problemRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Problem publishProblem(String username, Long courseId, ProblemDto problemDto) {
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundException::new);
        User user = userRepository.findByEmail(username).orElseThrow(NotFoundException::new);
        if (!course.getAuthor().equals(user)) {
            throw new NotAllowedOperationException();
        }

        Problem problem = modelMapper.map(problemDto, Problem.class);
        problem.setCourse(course);

        return problemRepository.save(problem);
    }
}
