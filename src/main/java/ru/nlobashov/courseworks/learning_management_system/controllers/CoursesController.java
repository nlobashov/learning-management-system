package ru.nlobashov.courseworks.learning_management_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nlobashov.courseworks.learning_management_system.models.Course;
import ru.nlobashov.courseworks.learning_management_system.services.CourseService;
import ru.nlobashov.courseworks.learning_management_system.services.LessonService;

@Controller
@RequestMapping({"/courses", "/"})
public class CoursesController
{
    private final String VIEWS_PATH = "views/courses";

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
        model.addAttribute("view", "views/courses/index");
        return "layout.html";
    }

    @GetMapping("/{id}")
    public String getCourse(@PathVariable("id") Long id, Model model)
    {
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        model.addAttribute("lessons", lessonService.getLessonsByCourse(course));
        model.addAttribute("view", getViewPath("course-detail"));
        return "layout.html";
    }

    @GetMapping("/create")
    public String showCreationForm(Model model)
    {
        model.addAttribute("course", new Course());
        model.addAttribute("view", getViewPath("create-course"));
        return "layout.html";
    }

    @PostMapping()
    public String createCourse(@ModelAttribute("course") Course course)
    {
        courseService.createCourse(course);
        return "redirect:/courses";
    }

    /**
     * Возвращает путь к представлению (View)
     * @param viewName название файла представления (View)
     * @return путь к представлению (View)
     */
    private String getViewPath(String viewName)
    {
        return String.format("%s/%s.html", VIEWS_PATH, viewName);
    }
}
