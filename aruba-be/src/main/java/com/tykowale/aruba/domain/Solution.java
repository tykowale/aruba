package com.tykowale.aruba.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
final public class Solution {

    private int answer;

    public Solution(int answer) {
        this.answer = answer;
    }
}
