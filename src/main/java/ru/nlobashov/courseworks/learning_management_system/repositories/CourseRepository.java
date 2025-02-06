package ru.nlobashov.courseworks.learning_management_system.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nlobashov.courseworks.learning_management_system.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>
{
}
