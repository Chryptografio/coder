package ru.croc.coder.repository;

import org.springframework.data.repository.CrudRepository;
import ru.croc.coder.domain.Course;

/**
 * todo Document type CourseRepository
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
}
