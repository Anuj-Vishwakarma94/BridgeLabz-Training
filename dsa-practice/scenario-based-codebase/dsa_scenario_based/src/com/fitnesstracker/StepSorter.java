package com.fitnesstracker;
public class StepSorter {

    // using bubble sort to sort from high steps to low steps
    public static void bubbleSort(User[] users, int size) {

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {

                if (users[j].getSteps() < users[j + 1].getSteps()) {
                    // swap adjacent users
                    User temp = users[j];
                    users[j] = users[j + 1];
                    users[j + 1] = temp;
                 }
               }
               }
             }

    public static void display(User[] users, int size) {
        int rank = 1;
        for (int i = 0; i < size; i++) {
            System.out.println(
                "Rank " + rank++ + " : " +
                users[i].getName() +
                " | Steps: " +
                users[i].getSteps()
            );
              }
              }
                    }
