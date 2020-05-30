package com.tykowale.aruba.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberGeneratorService {


    public int getRandomNumber(int low, int high) {
        Random r = new Random();

        return r.nextInt(high - low) + low;
    }

    public int getRandomNumber() {
        return getRandomNumber(1, 100);
    }
}
