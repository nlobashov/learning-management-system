package ru.nlobashov.courseworks.learning_management_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController
{
    @GetMapping("/home")
    public String getHomePage()
    {
        return "index.html";
    }
}
