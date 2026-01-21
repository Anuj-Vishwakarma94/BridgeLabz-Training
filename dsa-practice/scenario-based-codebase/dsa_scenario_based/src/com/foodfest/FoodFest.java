package com.foodfest;

import java.util.Scanner;

public class FoodFest {

    public static Stall[] mergeSort(Stall[] arr, int left, int right) {
        if (left == right) {
            return new Stall[]{arr[left]};
        }

        int mid = (left + right) / 2;

        Stall[] leftArr = mergeSort(arr, left, mid);
        Stall[] rightArr = mergeSort(arr, mid + 1, right);

        return merge(leftArr, rightArr);
    }

    private static Stall[] merge(Stall[] left, Stall[] right) {
        Stall[] result = new Stall[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].footfall <= right[j].footfall) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stalls: ");
        int n = sc.nextInt();
        sc.nextLine();

        Stall[] stalls = new Stall[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter stall name: ");
            String name = sc.nextLine();

            System.out.print("Enter footfall: ");
            int footfall = sc.nextInt();
            sc.nextLine();

            stalls[i] = new Stall(name, footfall);
        }

        Stall[] sortedStalls = mergeSort(stalls, 0, stalls.length - 1);

        System.out.println("\nSorted Stalls by Footfall:");
        for (Stall s : sortedStalls) {
            System.out.println(s.stallName + " - " + s.footfall);
        }

        sc.close();
    }
}
