package ru.croc.coder.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * todo Document type Problem
 */
@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descriotion;

    private Difficulty difficulty;

    private List<String> input; // TODO

    private List<String> output; // TODO

    private String template;

    private String solution;
}
