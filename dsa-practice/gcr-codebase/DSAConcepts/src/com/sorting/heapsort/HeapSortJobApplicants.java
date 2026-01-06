package com.sorting.heapsort;

import java.util.Arrays;

public class HeapSortJobApplicants {

    public static void main(String[] args) {

        int[] salaries = {75000, 50000, 70000, 60000, 85000};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(salaries));

        HeapSort.sort(salaries);

        System.out.println("After Sorting (Ascending):");
        System.out.println(Arrays.toString(salaries));
    }
}
