package com.tykowale.aruba.dto;

import com.tykowale.aruba.domain.Problem;
import com.tykowale.aruba.domain.Solution;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
final public class MathAnswer {

    private Problem previousProblem;
    private Solution solution;

}
