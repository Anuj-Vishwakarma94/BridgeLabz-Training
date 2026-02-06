package com.optionalclass.employee;

import java.util.*;

public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {

        Employee manager = new Employee(
                1, "Andrew", null, "Tate",
                "andrew@office.com", 50000.0, null, "Corporate Plan"
        );

        employees.add(manager);

        employees.add(new Employee(
                2, "Anuj", null, "Vishwakarma",
                "anuj@office.com", null, manager, null
        ));
    }

    public Optional<Employee> findByEmail(String email) {
        return employees.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst();
    }
}

