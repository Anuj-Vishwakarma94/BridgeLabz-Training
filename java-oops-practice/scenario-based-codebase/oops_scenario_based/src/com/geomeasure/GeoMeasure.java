package com.geomeasure;
import java.util.ArrayList;
import java.util.Scanner;

public class GeoMeasure {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> results = new ArrayList<>();

        System.out.println(" GeoMeasure Solutions ");
        System.out.println(" Line Length Comparator ");
        System.out.println("-------------------------");

        System.out.print("Enter number of comparisons: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nComparison " + i);

            System.out.println("Enter coordinates for Line 1:");
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();

            Line line1 = new Line(x1, y1, x2, y2);

            System.out.println("Enter coordinates for Line 2:");
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            double x4 = sc.nextDouble();
            double y4 = sc.nextDouble();

            Line line2 = new Line(x3, y3, x4, y4);

            double len1 = line1.getLength();
            double len2 = line2.getLength();

            String result;
            if (len1 == len2) {
                result = "Both lines are equal in length";
            } else if (len1 > len2) {
                result = "Line 1 is longer";
            } else {
                result = "Line 2 is longer";
            }

            System.out.println(result);
            results.add(result);
        }

        System.out.println("\n--- Summary of Comparisons ---");
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Comparison " + (i + 1) + ": " + results.get(i));
        }

        sc.close();
    }
}
