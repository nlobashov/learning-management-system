package ru.nlobashov.courseworks.learning_management_system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.nlobashov.courseworks.learning_management_system.models.Course;
import ru.nlobashov.courseworks.learning_management_system.services.CourseService;
import ru.nlobashov.courseworks.learning_management_system.services.LessonService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LearningManagementSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(LearningManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(CourseService courseService,
                                  LessonService lessonService)
    {
        return args -> {
            List<Course> courseList = new ArrayList<>();
            for (int i = 1; i <= 10; i++)
            {
                courseList.add(courseService.createCourse("Курс #" + i));
            }
            for (int i = 1; i <= 5; i++)
            {
                lessonService.createLesson("Занятие #" + i, "description!", courseList.getFirst(), i);
            }
            for (int i = 1; i <= 3; i++)
            {
                lessonService.createLesson("Занятие #" + i, "description!", courseList.getLast(), i);
            }
        };
    }
}