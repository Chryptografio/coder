package ru.croc.coder.domain;

import javax.persistence.*;

/**
 * todo Document type Solution
 */
@Entity
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String solution;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;
}
