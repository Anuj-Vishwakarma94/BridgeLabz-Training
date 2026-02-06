package com.optionalclass.employee;

public class EmployeeService {

    public static void main(String[] args) {

        EmployeeRepository repo = new EmployeeRepository();

        Employee emp = repo.findByEmail("anuj@office.com")
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        emp.getManager()
                .ifPresent(m -> System.out.println(m.getEmail()));

        double bonus = emp.getBonus()
                .orElse(0.0);

        String insurance = emp.getInsurance()
                .orElse("No Insurance");

        emp.getMiddleName()
                .ifPresent(System.out::println);

        System.out.println(bonus);
        System.out.println(insurance);
    }
}

