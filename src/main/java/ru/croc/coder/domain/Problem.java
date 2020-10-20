package ru.croc.coder.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * todo Document type Problem
 */
@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descriotion;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private List<String> input; // TODO

    private List<String> output; // TODO

    private String template;

    private String referenceSolution;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<String> solutions;
}
