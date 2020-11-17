package ru.croc.coder.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * todo Document type Course
 */
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="author_id")
    private User author;

    @Column(nullable = false)
    private String name;

//    @Column(nullable = false, columnDefinition = "default true")
//    private Boolean opened;

    @Lob
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Problem> problems;

    @ManyToMany(mappedBy = "attendedCourses")
    private Set<User> attendees;

    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Course setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Set<Problem> getProblems() {
        return problems;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

//    public Boolean isOpened() {
//        return opened;
//    }
//
//    public Course setOpened(Boolean opened) {
//        this.opened = opened;
//        return this;
//    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }
}
