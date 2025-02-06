package ru.nlobashov.courseworks.learning_management_system.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nlobashov.courseworks.learning_management_system.models.Course;
import ru.nlobashov.courseworks.learning_management_system.models.Lesson;

import java.util.List;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long>
{
    List<Lesson> findByCourse(Course course);
}