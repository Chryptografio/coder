package ru.croc.coder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.croc.coder.domain.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
}
