package ru.croc.coder;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.croc.coder.domain.*;
import ru.croc.coder.repository.CourseRepository;
import ru.croc.coder.repository.ProblemRepository;
import ru.croc.coder.repository.UserRepository;

@Component
@Slf4j
@AllArgsConstructor
public class Init implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final ProblemRepository problemRepository;

    @Override
    public void run(String[] args) {
        log.info("Init application");
        String createdUserMessage = "Created user id: {}";
        String createdCourseMessage = "Created course id: {}";
        String createdProblemMessage = "Created problem id: {}";

        long numUser = userRepository.count();
        log.info("Number of users: {}", numUser);

        User user1 = new User()
            .setFirstName("Evgeny")
            .setPassword("hello")
            .setLastName("Pisarenko")
            .setEmail("episarenko@croc.ru")
            .setRole(Role.AUTHOR);

        Long userId1 = userRepository.save(user1).getId();
        log.info(createdUserMessage, userId1);

        User user2 = new User()
            .setFirstName("John")
            .setPassword("hello")
            .setLastName("Karry")
            .setEmail("johnkennedy@example.co");

        Long userId2 = userRepository.save(user2).getId();
        log.info(createdUserMessage, userId2);

        User user3 = new User()
            .setFirstName("Ashly")
            .setPassword("hello")
            .setLastName("Jones")
            .setEmail("ashleyjones@example.com");

        Long userId3 = userRepository.save(user3).getId();
        log.info(createdUserMessage, userId3);

        User user4 = new User()
            .setFirstName("Samantha")
            .setPassword("hello")
            .setLastName("Loch")
            .setEmail("samantha@example.com");

        Long userId4 = userRepository.save(user4).getId();
        log.info(createdUserMessage, userId4);

        Course course1 = new Course().setAuthor(user1).setName("First course");
        Long courseId1 = courseRepository.save(course1).getId();
        log.info(createdCourseMessage, courseId1);

        Course course2 = new Course().setAuthor(user1).setName("Second course");
        Long courseId2 = courseRepository.save(course2).getId();
        log.info(createdCourseMessage, courseId2);

        Problem problem1 = new Problem()
            .setCourse(course1)
            .setDescription("Problem 1")
            .setDifficulty(Difficulty.EASY)
            .setReferenceSolution("Reference solution")
            .setTemplate("Basic Template");

        Long problemId1 = problemRepository.save(problem1).getId();
        log.info(createdProblemMessage, problemId1);
    }
}
