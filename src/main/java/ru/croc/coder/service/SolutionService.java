package ru.croc.coder.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Problem;
import ru.croc.coder.domain.Solution;
import ru.croc.coder.domain.User;
import ru.croc.coder.repository.ProblemRepository;
import ru.croc.coder.repository.SolutionRepository;
import ru.croc.coder.repository.UserRepository;
import ru.croc.coder.service.exception.NotFoundException;
import ru.croc.coder.service.exception.ProblemConstraintException;

// TODO review and add some features

@Service
@AllArgsConstructor
public class SolutionService {
    private UserRepository userRepository;

    private ProblemRepository problemRepository;

    private SolutionRepository solutionRepository;

    public Solution submit(Long userId, Long problemId, String code) {
        User user = userRepository.findById(userId)
            .orElseThrow(NotFoundException::new);
        Problem problem = problemRepository.findById(problemId)
            .orElseThrow(NotFoundException::new);

        Long maxSize = problem.getProblemConstraint().getMaxSize();

        if (maxSize == null || code.length() < maxSize) {
            throw new ProblemConstraintException();
        }

        Solution solution = new Solution()
            .setAuthor(user)
            .setProblem(problem)
            .setSolution(code);

        return solutionRepository.save(solution);
    }
}
