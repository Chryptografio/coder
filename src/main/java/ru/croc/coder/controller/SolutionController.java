package ru.croc.coder.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.croc.coder.domain.Solution;
import ru.croc.coder.dto.SolutionDto;
import ru.croc.coder.service.SolutionService;

/**
 * todo Document type ProblemController
 */
@RestController
public class SolutionController {
    private SolutionService solutionService;

    private ModelMapper modelMapper;

    @Autowired
    public SolutionController(SolutionService solutionService, ModelMapper modelMapper) {
        this.solutionService = solutionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/users/{userId}/problems/{problemId}/solutions")
    public SolutionDto submit(@PathVariable Long userId, @PathVariable Long problemId, @RequestBody String code) {
        Solution solution = solutionService.submit(userId, problemId, code);
        return convertToDto(solution);
    }

    private SolutionDto convertToDto(Solution solution) {
        SolutionDto solutionDto = modelMapper.map(solution, SolutionDto.class);
        return solutionDto;
    }

    private Solution convertToEntity(SolutionDto solutionDto) {
        Solution solution = modelMapper.map(solutionDto, Solution.class);
        return solution;
    }
}
