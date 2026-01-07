package com.linearandbinarysearch.binarysearch;
public class RotationPointBinarySearch {

    public static int findRotationIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;  
    }

    public static void main(String[] args) {

        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };

        int index = findRotationIndex(arr);

        System.out.println("Index of smallest element: " + index);
        System.out.println("Smallest element is: " + arr[index]);
    }
}
