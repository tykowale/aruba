package com.tykowale.aruba.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
final public class Problem {

    int x;
    int y;
    Operation op;

    public Problem(int x, int y, Operation op) {
        this.x = x;
        this.y = y;
        this.op = op;
    }
}
