package com.lamdaexpresions.basicsystemtasks;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        // 1. Run task in separate thread
        TaskRunner task = () -> System.out.println("Task running in thread");
        new Thread(() -> task.run()).start();

        // 2. Print numbers from list
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("\nNumbers:");
        nums.forEach(n -> System.out.println(n));

        // 3. Even or Odd
        EvenOddCheck eo = n -> n % 2 == 0;
        System.out.println("\nIs 4 Even? " + eo.isEven(4));

        // 4. Add two numbers
        AddNumbers add = (a, b) -> a + b;
        System.out.println("\nSum: " + add.add(10, 20));

        // 5. Greater of two numbers
        GreaterNumber gr = (a, b) -> a > b ? a : b;
        System.out.println("\nGreater Number: " + gr.greater(15, 9));
    }
}
