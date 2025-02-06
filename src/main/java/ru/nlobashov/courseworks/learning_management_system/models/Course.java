package ru.nlobashov.courseworks.learning_management_system.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

    public Course()
    {
    }

    public Course(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.lessons = new ArrayList<>();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<Lesson> getLessons()
    {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons)
    {
        this.lessons = lessons;
    }
}
