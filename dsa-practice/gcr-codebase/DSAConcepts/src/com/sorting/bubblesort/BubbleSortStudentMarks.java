package com.sorting.bubblesort;

import java.util.Arrays;

public class BubbleSortStudentMarks {

    public static void main(String[] args) {

        int[] studentMarks1 = {45, 78, 62, 89, 34, 90};

        System.out.println("Marks before sorting:");
        System.out.println(Arrays.toString(studentMarks1));

        BubbleSort.sort(studentMarks1);

        System.out.println("Marks after sorting (Ascending):");
        System.out.println(Arrays.toString(studentMarks1));
        
        
        int[] studentMarks2 = {34, 45, 62, 78, 89, 90};

        System.out.println("Marks before sorting:");
        System.out.println(Arrays.toString(studentMarks2));
        

        OptimizedBubbleSort.sort(studentMarks2);

        System.out.println("Marks after sorting (Ascending):");
        System.out.println(Arrays.toString(studentMarks2));
    }
}
