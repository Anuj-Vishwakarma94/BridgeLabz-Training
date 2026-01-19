package com.icecreamrush;
import java.util.Scanner;

public class IceCreamRush{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" IceCreamRush – Weekly Sales ");
        System.out.println("------------------------------\n");

        System.out.print("Enter number of flavors: ");
        int n = sc.nextInt();
        sc.nextLine();

        Flavor[] flavors = new Flavor[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nFlavor name: ");
            String name = sc.nextLine();

            System.out.print("Times sold this week: ");
            int sales = sc.nextInt();
            sc.nextLine();

            flavors[i] = new Flavor(name, sales);
        }

        System.out.println("\nBefore Sorting:");
        IceCreamSorter.display(flavors, n);

        IceCreamSorter.bubbleSort(flavors, n);

        System.out.println("\nAfter Sorting (Most Popular → Least Popular):");
        IceCreamSorter.display(flavors, n);

        sc.close();
    }
}
