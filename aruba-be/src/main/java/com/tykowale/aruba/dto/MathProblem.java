package com.tykowale.aruba.dto;


import com.tykowale.aruba.domain.PreviousResult;
import com.tykowale.aruba.domain.Problem;
import lombok.Data;

@Data
final public class MathProblem {

    private Problem problem;
    private PreviousResult previousResult;

    public MathProblem(Problem problem, PreviousResult previousResult) {
        this.problem = problem;
        this.previousResult = previousResult;
    }
}
