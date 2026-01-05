package com.hashmapandhashfunctions.longestconsecutivesequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int findLongestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // check if num is start of sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                // count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
