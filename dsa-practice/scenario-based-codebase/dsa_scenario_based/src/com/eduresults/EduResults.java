package com.eduresults;
import java.util.Scanner;

public class EduResults {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(" EduResults – State Rank Generator ");
        System.out.println("------------------------------------\n");

        System.out.print("Enter total number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        System.out.println("\nEnter student details :");
        for (int i = 0; i < n; i++) {
            System.out.print("Student name: ");
            String name = sc.nextLine();

            System.out.print("Score: ");
            int score = sc.nextInt();
            sc.nextLine();

            students[i] = new Student(name, score);
        }

        System.out.println("\nBefore Merging:");
        RankMerger.display(students);

        RankMerger.mergeSort(students, 0, n - 1);

        System.out.println("\nFinal State-Level Rank List:");
        RankMerger.display(students);

        sc.close();
    }
}
