package ru.croc.coder.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.croc.coder.domain.Problem;
import ru.croc.coder.dto.ProblemDto;
import ru.croc.coder.service.ProblemService;

/**
 * todo Document type ProblemController
 */
@RestController
@RequestMapping("problems")
public class ProblemController {

    ProblemService problemService;

    ModelMapper modelMapper;

    @Autowired
    public ProblemController(ProblemService problemService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/course/{courseId}/add")
    public ProblemDto publishProblem(@PathVariable Long courseId, @RequestBody ProblemDto problemDto) {
        Problem problem = problemService.publishProblem(courseId, modelMapper.map(problemDto, Problem.class));

        return modelMapper.map(problem, ProblemDto.class);
    }
}
