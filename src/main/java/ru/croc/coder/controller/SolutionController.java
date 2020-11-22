package ru.croc.coder.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.croc.coder.dto.SolutionDto;
import ru.croc.coder.service.SolutionService;

@RestController
@RequestMapping("/solutions")
@AllArgsConstructor
public class SolutionController {

    private final SolutionService solutionService;

    @PostMapping("/problem/{problemId}")
    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    public SolutionDto submit(Authentication authentication, @PathVariable Long problemId, @RequestBody String code) {
        String username = authentication.getName();

        return solutionService.submit(username, problemId, code);
    }
}
