package com.tykowale.aruba.domain.dto;

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
