package com.tykowale.aruba.service;

import com.tykowale.aruba.domain.Operation;
import com.tykowale.aruba.domain.Problem;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    private NumberGeneratorService numberGeneratorService;

    public ProblemService(NumberGeneratorService numberGeneratorService) {
        this.numberGeneratorService = numberGeneratorService;
    }

    public Problem genAdditionProblem() {
        return new Problem(
            numberGeneratorService.getRandomNumber(),
            numberGeneratorService.getRandomNumber(),
            Operation.ADD
        );
    }
}
