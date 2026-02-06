package com.lamdaexpresions.employeemanagementsystem;

import java.util.*;

public class EmployeeSort {

    public static void sortBySalary(List<Employee> list) {
        list.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));
    }
}
