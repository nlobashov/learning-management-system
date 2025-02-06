package ru.nlobashov.courseworks.learning_management_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nlobashov.courseworks.learning_management_system.models.Course;
import ru.nlobashov.courseworks.learning_management_system.services.CourseService;
import ru.nlobashov.courseworks.learning_management_system.services.LessonService;

@Controller
@RequestMapping(path = "courses")
public class CoursesController
{
    private final CourseService courseService;
    private final LessonService lessonService;

    @Autowired
    public CoursesController(CourseService courseService, LessonService lessonService)
    {
        this.courseService = courseService;
        this.lessonService = lessonService;
    }

    @GetMapping()
    public String getCourses(Model model)
    {
        model.addAttribute("courses", courseService.getAllCourse());
        model.addAttribute("page", "views/courses/index");
        return "layout.html";
    }

    @GetMapping("/{id}")
    public String getCourse(@PathVariable("id") Long id, Model model)
    {
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        model.addAttribute("lessons", lessonService.getLessonsByCourse(course));
        model.addAttribute("page", "views/courses/course-detail.html");
        return "layout.html";
    }
}
