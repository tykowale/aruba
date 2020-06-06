package com.tykowale.aruba.service;

import com.tykowale.aruba.domain.dto.Operation;
import com.tykowale.aruba.domain.dto.PreviousResult;
import com.tykowale.aruba.domain.dto.Problem;
import com.tykowale.aruba.dto.MathAnswer;
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

    public PreviousResult checkAnswer(MathAnswer answer) {
        Problem previousProblem = answer.getPreviousProblem();
        int correctAnswer = previousProblem.getX() + previousProblem.getY();
        boolean correct = correctAnswer == answer.getSolution().getAnswer();

        return new PreviousResult(correctAnswer, correct);
    }
}
