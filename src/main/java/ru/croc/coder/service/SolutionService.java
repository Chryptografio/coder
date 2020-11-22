package ru.croc.coder.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.croc.coder.domain.Problem;
import ru.croc.coder.domain.ProcessStatus;
import ru.croc.coder.domain.Solution;
import ru.croc.coder.domain.User;
import ru.croc.coder.dto.SolutionDto;
import ru.croc.coder.repository.ProblemRepository;
import ru.croc.coder.repository.SolutionRepository;
import ru.croc.coder.repository.UserRepository;
import ru.croc.coder.service.exception.NotAllowedOperationException;
import ru.croc.coder.service.exception.NotFoundException;
import ru.croc.coder.service.exception.ProblemConstraintException;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class SolutionService {

    private final UserRepository userRepository;
    private final ProblemRepository problemRepository;
    private final SolutionRepository solutionRepository;
    private final ModelMapper modelMapper;

    @Transactional(isolation = Isolation.SERIALIZABLE, noRollbackFor = ProblemConstraintException.class)
    public SolutionDto submit(String username, Long problemId, String code) {
        User user = userRepository.findByEmail(username)
            .orElseThrow(NotFoundException::new);
        Problem problem = problemRepository.findById(problemId)
            .orElseThrow(NotFoundException::new);

        user.getAttendedCourses().stream()
            .filter(course -> course.equals(problem.getCourse()))
            .findFirst()
            .orElseThrow(NotAllowedOperationException::new);

        Solution solution = new Solution()
            .setAuthor(user)
            .setProblem(problem)
            .setSolution(code)
            .setProcessStatus(ProcessStatus.QUEUED);

        return modelMapper.map(solutionRepository.save(solution), SolutionDto.class);
    }

    @Async
    @Scheduled(fixedRate = 1_000, initialDelay = 3_000)
    public void checkSolution() throws InterruptedException {
        Solution solution = null;
        try {
            Optional<Solution> result = peekNextSolution();
            if (result.isEmpty())
                return;

            solution = result.get();
            boolean passed = runTests(solution);
            solution.setPassed(passed);
        } finally {
            if (solution != null) {
                solution.setProcessStatus(ProcessStatus.COMPLETED);
                solutionRepository.save(solution);
            }
        }
    }

//    @Transactional(isolation = Isolation.SERIALIZABLE) Sonarlint gets angry
    public Optional<Solution> peekNextSolution() {
        Optional<Solution> result = solutionRepository.findAnyQueued();

        if (result.isPresent()) {
            Solution solution = result.get();
            solution.setProcessStatus(ProcessStatus.IN_PROGRESS);
            solutionRepository.save(solution);
        }

        return result;
    }

    private boolean runTests(Solution solution) throws InterruptedException {
        Thread.sleep(15_000);

        return new Random().nextBoolean();
    }
}
