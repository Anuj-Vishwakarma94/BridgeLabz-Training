package com.browserbuddy;

import java.util.Stack;
import java.util.Scanner;
public class BrowserBuddy {
    static Stack<TabHistory> closedTabs = new Stack<>();
    static TabHistory currentTab = new TabHistory();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- BrowserBuddy Menu ---");
            System.out.println("1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Close Tab");
            System.out.println("5. Reopen Closed Tab");
            System.out.println("6. Show Current Page");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    currentTab.visitPage(url);
                    break;

                case 2:
                    currentTab.goBack();
                    break;

                case 3:
                    currentTab.goForward();
                    break;

                case 4:
                    closedTabs.push(currentTab);
                    currentTab = new TabHistory();
                    System.out.println("Tab closed");
                    break;

                case 5:
                    if (!closedTabs.isEmpty()) {
                        currentTab = closedTabs.pop();
                        System.out.println("Tab reopened");
                    } else {
                        System.out.println("No closed tabs");
                    }
                    break;

                case 6:
                    currentTab.showCurrentPage();
                    break;

                case 7:
                    System.out.println("Browser closed");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}