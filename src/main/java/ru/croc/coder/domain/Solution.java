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

    private String solution;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "problem_id", nullable = false)
    private Problem problem;
}
