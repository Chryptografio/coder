package ru.croc.coder.domain;

import javax.persistence.*;

/**
 * todo Document type Solution
 */
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String solution;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private User author;

    @ManyToOne
    @Column(nullable = false)
    private Problem problem;
}
