package com.eventmanager;
public class QuickSortUtil {

    public static void quickSort(Ticket[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(Ticket[] arr, int low, int high) {
        double pivot = arr[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].price < pivot) {
                i++;
                Ticket temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Ticket temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void display(Ticket[] arr) {
        for (Ticket t : arr) {
            System.out.println("₹" + t.price);
        }
    }
}
