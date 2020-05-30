package com.tykowale.aruba.domain;

import lombok.Data;

@Data
final public class Problem {

    final int x;
    final int y;
    final Operation op;

    public Problem(int x, int y, Operation op) {
        this.x = x;
        this.y = y;
        this.op = op;
    }
}
