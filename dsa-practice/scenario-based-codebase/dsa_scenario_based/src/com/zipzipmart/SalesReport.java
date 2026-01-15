package com.zipzipmart;
public class SalesReport {

    public static void mergeSort(Transaction[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(Transaction[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Transaction[] L = new Transaction[n1];
        Transaction[] R = new Transaction[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Stable merge: date first, then amount
        while (i < n1 && j < n2) {
            if (L[i].date.compareTo(R[j].date) < 0 ||
               (L[i].date.equals(R[j].date) && L[i].amount <= R[j].amount)) {

                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void display(Transaction[] arr) {
        for (Transaction t : arr) {
            System.out.println(t.date + " | ₹" + t.amount);
        }
    }
}
