package com.linearandbinarysearch.challangeproblem;

import java.util.Arrays;

public class SearchChallenge {
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        boolean[] present = new boolean[n + 1];

        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive: " + missing);

        Arrays.sort(arr);

        int index = binarySearch(arr, target);
        System.out.println("Index of target after sorting: " + index);
    }
}
