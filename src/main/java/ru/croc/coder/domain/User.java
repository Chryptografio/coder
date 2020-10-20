package ru.croc.coder.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;

	private String firstName;

	private String lastName;

	@Column(columnDefinition = "STUDENT")
	@Enumerated(EnumType.STRING)
	private Role role;

	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@ManyToMany
	private Set<Course> courses;

	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
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
}
