package ru.croc.coder.dto;

import ru.croc.coder.domain.Availability;

/**
 * todo Document type CourseDto
 */
public class CourseDto {
    private Long id;

    private String name;

    private String description;

    private Availability availability = Availability.CLOSED;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
