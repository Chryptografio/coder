package ru.croc.coder.repository;

import org.springframework.data.repository.CrudRepository;
import ru.croc.coder.domain.Problem;

import java.util.List;

public interface ProblemRepository extends CrudRepository<Problem, Long> {
    List<Problem> findAllByCourseId(Long courseId);
}
