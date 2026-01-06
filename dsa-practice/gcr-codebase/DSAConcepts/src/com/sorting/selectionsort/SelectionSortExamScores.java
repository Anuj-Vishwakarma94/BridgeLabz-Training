package com.sorting.selectionsort;

import java.util.Arrays;

public class SelectionSortExamScores {

    public static void main(String[] args) {

        int[] examScores = {78, 45, 89, 62, 91, 54};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(examScores));

        SelectionSort.sort(examScores);

        System.out.println("After Sorting (Ascending):");
        System.out.println(Arrays.toString(examScores));
    }
}
