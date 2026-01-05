package com.hashmapandhashfunctions.checkforapairwithgivensuminanarray;

import java.util.HashMap;
import java.util.Map;

public class PairWithGivenSum {

    public static boolean hasPair(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;

            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + complement + " + " + num + " = " + target);
                return true;
            }

            map.put(num, 1); 
        }

        System.out.println("No pair found with sum " + target);
        return false;
    }
}
