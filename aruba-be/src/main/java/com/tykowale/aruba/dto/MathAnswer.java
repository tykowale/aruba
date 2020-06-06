package com.tykowale.aruba.dto;

import com.tykowale.aruba.domain.dto.Problem;
import com.tykowale.aruba.domain.dto.Solution;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
final public class MathAnswer {

    private Problem previousProblem;
    private Solution solution;

}
