package com.tykowale.aruba.controller;


import com.tykowale.aruba.domain.Problem;
import com.tykowale.aruba.service.ProblemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProblemController {

    private ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/addition")
    public Problem genAdditionProblem() {
        return problemService.genAdditionProblem();
    }
}
