package com.examcell;
import java.util.Scanner;

public class ExamCell {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

     
        System.out.println("ExamCell – Student Rank System ");
        

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nStudent name: ");
            String name = sc.nextLine();

            System.out.print("Score:(1-100) ");
            int score = sc.nextInt();
            sc.nextLine();

            students[i] = new Student(name, score);
        }

        System.out.println("\nBefore Ranking:");
        RankGenerator.display(students);

        RankGenerator.mergeSort(students, 0, n - 1);

        System.out.println("\nState-Level Rank List:");
        RankGenerator.display(students);

        sc.close();
    }
}
