package ru.croc.coder.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * todo Document type Course
 */
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id", nullable=false)
    private User author;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<Problem> problems;

    @ManyToMany
    private Set<User> attendees;
}
