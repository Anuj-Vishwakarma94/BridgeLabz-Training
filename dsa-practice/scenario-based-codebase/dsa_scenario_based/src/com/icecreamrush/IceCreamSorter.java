package com.icecreamrush;
public class IceCreamSorter {

    // Bubble Sort by sales (high → low)
    public static void bubbleSort(Flavor[] flavors, int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (flavors[j].sales < flavors[j + 1].sales) {
                    // swap adjacent flavors
                    Flavor temp = flavors[j];
                    flavors[j] = flavors[j + 1];
                    flavors[j + 1] = temp;
                }
            }
        }
    }

    public static void display(Flavor[] flavors, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(
                flavors[i].name + " | Sold: " + flavors[i].sales
            );
        }
    }
}
