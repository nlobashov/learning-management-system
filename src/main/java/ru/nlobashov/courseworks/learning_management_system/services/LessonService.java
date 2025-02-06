package ru.nlobashov.courseworks.learning_management_system.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nlobashov.courseworks.learning_management_system.models.Course;
import ru.nlobashov.courseworks.learning_management_system.models.Lesson;
import ru.nlobashov.courseworks.learning_management_system.repositories.LessonRepository;

import java.util.List;

@Service
public class LessonService
{
    private LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository)
    {
        this.lessonRepository = lessonRepository;
    }

    @Transactional
    public List<Lesson> findAllLessons()
    {
        return (List<Lesson>) lessonRepository.findAll();
    }

    @Transactional
    public List<Lesson> getLessonsByCourse(Course course)
    {
        return lessonRepository.findByCourse(course);
    }

    @Transactional
    public Lesson createLesson(String theme, String description, Course course, int lessonNumber)
    {
        Lesson lesson = lessonRepository.save(new Lesson(theme, description, course, lessonNumber));
        course.getLessons().add(lesson);
        return lesson;
    }
}
