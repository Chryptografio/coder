package ru.croc.coder.domain;

import javax.persistence.*;

/**
 * todo Document type InputOutput
 */

@Entity
public class InputOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String input;

    private String output;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;
}
