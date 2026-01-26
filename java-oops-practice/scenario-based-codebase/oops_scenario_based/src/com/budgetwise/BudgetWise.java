package com.budgetwise;

import java.util.Scanner;

public class BudgetWise {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================== BUDGETWISE APP =================");

        System.out.print("Enter monthly budget amount: ");
        double monthlyAmount = sc.nextDouble();
        MonthlyBudget budget = new MonthlyBudget(monthlyAmount);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Set Category Limit");
            System.out.println("2. Add Transaction");
            System.out.println("3. Generate Monthly Report");
            System.out.println("4. Detect Monthly Overspend");
            System.out.println("5. Annual Budget Report");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter category name: ");
                    String category = sc.nextLine();
                    System.out.print("Enter limit amount: ");
                    double limit = sc.nextDouble();
                    budget.setCategoryLimit(category, limit);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Type (income/expense): ");
                    String type = sc.nextLine();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    System.out.print("Enter category/description: ");
                    String desc = sc.nextLine();

                    budget.addTransaction(amount, type, date, desc);
                    break;

                case 3:
                    budget.generateReport();
                    break;

                case 4:
                    budget.detectOverspend();
                    break;

                case 5:
                    System.out.print("Enter annual budget amount: ");
                    double annualAmt = sc.nextDouble();
                    AnnualBudget annual = new AnnualBudget(annualAmt);

                    System.out.print("How many annual transactions? ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Amount: ");
                        double a = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Type (income/expense): ");
                        String t = sc.nextLine();

                        System.out.print("Date (YYYY-MM-DD): ");
                        String d = sc.nextLine();

                        System.out.print("Description: ");
                        String de = sc.nextLine();

                        annual.addTransaction(a, t, d, de);
                    }

                    annual.generateReport();
                    annual.detectOverspend();
                    break;

                case 6:
                    System.out.println("\n================== Thanks for using =================");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
