package com.tykowale.aruba.domain;

public enum Operation {
    ADD('+'),
    SUBTRACT('-'),
    DIVIDE('/'),
    MULTIPLY('*');

    private char action;

    Operation(char action) {
        this.action = action;
    }
}
