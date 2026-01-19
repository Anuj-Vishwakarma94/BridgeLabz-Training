package com.flashdealz;
public class QuickSortUtil {

    public static void quickSort(Product[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(Product[] arr, int low, int high) {
        int pivot = arr[high].getDiscount();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getDiscount() > pivot) { // higher discount first
                i++;
                Product temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Product temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void display(Product[] arr) {
        for (Product p : arr) {
            System.out.println(p.getName() + " | Discount: " + p.getDiscount() + "%");
        }
    }
}
