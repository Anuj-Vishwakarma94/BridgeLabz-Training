package com.linearandbinarysearch.binarysearch;
public class PeakElementBinarySearch {

    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;   
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeak(arr);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}
