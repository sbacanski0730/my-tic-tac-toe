package com.company;

import java.util.Random;

public class Computer {
    public int computerRandom() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }
}
