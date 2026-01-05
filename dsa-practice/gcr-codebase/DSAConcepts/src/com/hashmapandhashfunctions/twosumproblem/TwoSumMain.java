package com.hashmapandhashfunctions.twosumproblem;
import java.util.Arrays;

public class TwoSumMain {
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 13;

        int[] result = TwoSum.findTwoSum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
