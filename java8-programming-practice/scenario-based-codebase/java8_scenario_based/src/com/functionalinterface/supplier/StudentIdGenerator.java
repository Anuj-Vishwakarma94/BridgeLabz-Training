package com.functionalinterface.supplier;

import java.util.Random;

public class StudentIdGenerator {

    public static int generate() {
        return new Random().nextInt(100000);
    }
}

