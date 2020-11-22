package ru.croc.coder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.croc.coder.domain.Problem;
import ru.croc.coder.dto.ProblemDto;
import ru.croc.coder.dto.ProblemsFileDto;
import ru.croc.coder.service.ProblemService;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/problems")
@AllArgsConstructor
public class ProblemController {

    private final ProblemService problemService;
    private final ModelMapper modelMapper;

    @PostMapping("/course/{courseId}")
    @PreAuthorize("hasAnyRole('ROLE_AUTHOR')")
    public ProblemDto publishProblem(Authentication authentication, @PathVariable Long courseId, @RequestBody ProblemDto problemDto) {
        String username = authentication.getName();
        Problem problem = problemService.publishProblem(username, courseId, problemDto);

        return modelMapper.map(problem, ProblemDto.class);
    }

    @GetMapping("/course/{courseId}")
    @PreAuthorize("hasAnyRole('ROLE_AUTHOR', 'ROLE_STUDENT')")
    public List<ProblemDto> getProblemsByCourse(Authentication authentication, @PathVariable Long courseId) {
        String username = authentication.getName();
        return problemService.getProblemsByCourse(username, courseId);
    }

    @PostMapping("/uploadFileModelAttribute/course/{courseId}")
    @PreAuthorize("hasAnyRole('ROLE_AUTHOR')")
    public ProblemsFileDto submit(Authentication authentication, @PathVariable Long courseId, @RequestParam("file") MultipartFile file) throws IOException {
        String username = authentication.getName();

        ObjectMapper objectMapper = new ObjectMapper();
        ProblemsFileDto problemsFileDto = objectMapper.readValue(file.getInputStream(), ProblemsFileDto.class);

        return problemService.publishProblems(username, courseId, problemsFileDto);
    }
}