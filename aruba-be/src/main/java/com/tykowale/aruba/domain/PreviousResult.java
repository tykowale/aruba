package com.tykowale.aruba.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
final public class PreviousResult {

    private int actualAnswer;
    private boolean correct;

    public PreviousResult(int actualAnswer, boolean correct) {
        this.actualAnswer = actualAnswer;
        this.correct = correct;
    }
}
