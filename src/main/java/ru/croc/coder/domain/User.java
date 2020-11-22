package ru.croc.coder.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name = "user_course",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> attendedCourses;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Course> createdCourses;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Solution> solutions;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public Set<Solution> getSolutions() {
        return solutions;
    }

    public User setSolutions(Set<Solution> solutions) {
        this.solutions.clear();
        this.solutions.addAll(solutions);
        return this;
    }

    public Set<Course> getAttendedCourses() {
        return attendedCourses;
    }

    public User setAttendedCourses(Set<Course> attendedCourses) {
        this.attendedCourses = attendedCourses;
        return this;
    }

    public Set<Course> getCreatedCourses() {
        return createdCourses;
    }

    public User setCreatedCourses(Set<Course> createdCourses) {
        this.createdCourses = createdCourses;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
            "email='" + email + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", role=" + role +
            '}';
    }
}
