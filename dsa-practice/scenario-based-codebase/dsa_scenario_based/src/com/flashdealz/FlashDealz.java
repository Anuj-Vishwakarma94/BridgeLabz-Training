package com.flashdealz;
import java.util.Scanner;

public class FlashDealz {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(" FlashDealz – Discount Sorter ");
        System.out.println("--------------------------------\n");

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nProduct name: ");
            String name = sc.nextLine();

            System.out.print("Discount (%): ");
            int discount = sc.nextInt();
            sc.nextLine();

            products[i] = new Product(name, discount);
        }

        System.out.println("\nBefore Sorting:");
        QuickSortUtil.display(products);

        QuickSortUtil.quickSort(products, 0, n - 1);

        System.out.println("\nAfter Sorting (Highest Discount → Lowest Discount):");
        QuickSortUtil.display(products);

        sc.close();
    }
}
