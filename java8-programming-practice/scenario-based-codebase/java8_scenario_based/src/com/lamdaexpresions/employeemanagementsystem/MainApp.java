package com.lamdaexpresions.employeemanagementsystem;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Anuj", 40000, 4));
        employees.add(new Employee(2, "Andrew", 28000, 2));
        employees.add(new Employee(3, "Emily", 55000, 6));
        employees.add(new Employee(4, "Hermoine", 32000, 3));

        // 1. Bonus calculation
        BonusCalculator bc = salary -> salary > 30000 ? salary * 0.10 : 0;
        System.out.println("Bonus: " + bc.calculate(40000));

        // 2. Sort by salary
        EmployeeSort.sortBySalary(employees);
        System.out.println("\nSorted by Salary:");
        employees.forEach(System.out::println);

        // 3. Promotion eligibility
        PromotionCheck pc = exp -> exp > 3;
        System.out.println("\nPromotion Eligible: " + pc.isEligible(4));

        // 4. Print employee details using lambda
        System.out.println("\nEmployee Details:");
        employees.forEach(e -> System.out.println(e));

        // 5. Compare two employees' salaries
        Comparator<Employee> salaryCompare =
                (e1, e2) -> Double.compare(e1.salary, e2.salary);

        System.out.println("\nSalary Comparison Result: "
                + salaryCompare.compare(employees.get(0), employees.get(1)));
    }
}
