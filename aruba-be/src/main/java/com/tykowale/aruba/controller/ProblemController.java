package com.tykowale.aruba.controller;


import com.tykowale.aruba.domain.PreviousResult;
import com.tykowale.aruba.dto.MathAnswer;
import com.tykowale.aruba.dto.MathProblem;
import com.tykowale.aruba.service.ProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProblemController {

    private ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @PostMapping("/addition")
    public ResponseEntity<MathProblem> genAdditionProblem(
        @RequestBody(required = false) MathAnswer answer
    ) {
        PreviousResult previousResult = null;

        if (answer != null) {
            previousResult = problemService.checkAnswer(answer);
        }

        MathProblem problem = new MathProblem(problemService.genAdditionProblem(), previousResult);

        return new ResponseEntity<>(problem, HttpStatus.OK);
    }
}
