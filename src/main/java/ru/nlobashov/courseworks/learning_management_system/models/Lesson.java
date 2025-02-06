package ru.nlobashov.courseworks.learning_management_system.models;

import jakarta.persistence.*;

@Entity
@Table(
    name = "lessons",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"course_id", "lessonNumber"})
    }
)
public class Lesson
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column(name = "lessonNumber")
    private int lessonNumber;

    public Lesson()
    {
    }

    public Lesson(String theme, String description, Course course, int lessonNumber)
    {
        this.theme = theme;
        this.description = description;
        this.course = course;
        this.lessonNumber = lessonNumber;
    }

    public Long getId()
    {
        return id;
    }

    public String getTheme()
    {
        return theme;
    }

    public void setTheme(String theme)
    {
        this.theme = theme;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public int getLessonNumber()
    {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber)
    {
        this.lessonNumber = lessonNumber;
    }
}
