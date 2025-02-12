package ru.nlobashov.courseworks.learning_management_system.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nlobashov.courseworks.learning_management_system.models.Course;
import ru.nlobashov.courseworks.learning_management_system.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService
{
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public List<Course> getAllCourse()
    {
        return (List<Course>) courseRepository.findAll();
    }

    @Transactional
    public Course findById(Long id)
    {
        Optional<Course> course= courseRepository.findById(id);
        return course.orElse(null);
    }

    @Transactional
    public Course createCourse(String name)
    {
        Course course = new Course(name, "Test description");
        return courseRepository.save(course);
    }

    @Transactional
    public void createCourse(Course course)
    {
        courseRepository.save(course);
    }
}
