package ru.croc.coder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.croc.coder.domain.ProcessStatus;
import ru.croc.coder.domain.Solution;

import java.util.Optional;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
    default Optional<Solution> findAnyQueued() {
        return findTopByProcessStatus(ProcessStatus.QUEUED);
    }

    Optional<Solution> findTopByProcessStatus(ProcessStatus processStatus);
}
