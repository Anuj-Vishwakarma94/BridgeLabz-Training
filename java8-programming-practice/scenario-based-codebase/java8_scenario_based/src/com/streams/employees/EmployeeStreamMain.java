package com.streams.employees;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamMain {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1, "Anuj", 22, "Male", "Senior Management", 2026, 700000));
		employees.add(new Employee(2, "Aryan", 22, "Male", "Sales", 2025, 75000));
		employees.add(new Employee(3, "Andrew", 23, "Male", "Security", 2026, 5000));
		employees.add(new Employee(4, "Tristan", 23, "Male", "Sales", 2023, 65000));
		employees.add(new Employee(5, "siri", 35, "Female", "HR", 2020, 70000));
		employees.add(new Employee(6, "Alexa", 21, "Male", "Product Development", 2020, 15000));
		
		
		System.out.println("\n1. Male and Female Count \n ");
		Map<String, Long> genderCount = 
				employees.stream()
						 .collect(Collectors.groupingBy(
								 Employee::getGender,
								 Collectors.counting()
						  ));
	    System.out.println(genderCount);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
	
	
		System.out.println("\n2. Departments \n");
		employees.stream()
				 .map(Employee::getDepartment)
				 .distinct()
				 .forEach(System.out::println);
		System.out.println("___________________________________________________________________________________________________________________________________________");
		
	
		System.out.println("\n3. Average Age By Gender \n ");
		Map<String, Double> avgAgeByGender = 
				employees.stream()
						 .collect(Collectors.groupingBy(
								 Employee::getGender,
								 Collectors.averagingInt(Employee::getAge)
						  ));
	    System.out.println(avgAgeByGender);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
		
		
	    System.out.println("\n4. Highest Paid Employee info \n");
	    Optional<Employee> highestPaidinfo = 
	    		employees.stream()
	    				 .max(Comparator.comparing(Employee::getSalary));
	    highestPaidinfo.ifPresent(System.out::println);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
		
		
	    System.out.println("\n5. Joined After 2024 \n");
		employees.stream()
		  		 .filter(e -> e.getYearOfJoining() > 2024)
		  		 .forEach(System.out::println);
		System.out.println("___________________________________________________________________________________________________________________________________________");
		
		
		System.out.println("\n6. Number of employees in each Departments \n");
		Map<String, Long> deptCount = 
				employees.stream()
				         .collect(Collectors.groupingBy(
				        		 Employee::getDepartment,
				        		 Collectors.counting()
				         ));
		System.out.println(deptCount);
		System.out.println("___________________________________________________________________________________________________________________________________________");
		
		
		System.out.println("\n7. Average Salary of each Department \n");
		Map<String, Double> avgSalaryByDept =
		employees.stream()
		 		 .collect(Collectors.groupingBy(
		 				 Employee::getDepartment,
		 				 Collectors.averagingDouble(Employee::getSalary)
		 		 ));
		System.out.println(avgSalaryByDept);
		System.out.println("___________________________________________________________________________________________________________________________________________");
		
		
		System.out.println("\n8. Youngest Male in Product Development \n");
        employees.stream()
                 .filter(e -> e.getGender().equalsIgnoreCase("Male"))
                 .filter(e -> e.getDepartment().equalsIgnoreCase("Product Development"))
                 .min(Comparator.comparing(Employee::getAge))
                 .ifPresent(System.out::println);
        System.out.println("___________________________________________________________________________________________________________________________________________");
    	
		
		System.out.println("\n9. Most Experienced Employee");
		Optional<Employee> mostExperienced =
				employees.stream()
				         .min(Comparator.comparing(Employee::getYearOfJoining));
		mostExperienced.ifPresent(System.out::println);
		System.out.println("___________________________________________________________________________________________________________________________________________");
		
        
        System.out.println("\n10. Male and Female count in Sales department");
        Map<String, Long> SalesCount =
        		employees.stream()
        		         .filter(e -> e.getDepartment().equalsIgnoreCase("Sales"))
        		         .collect(Collectors.groupingBy(
        		        		 Employee::getGender,
        		        		 Collectors.counting()
        		         ));
        System.out.println(SalesCount);
        System.out.println("___________________________________________________________________________________________________________________________________________");
    	
        
        System.out.println("\n11. Average Salary by Gender");
        Map<String, Double> AvgSalaryByGender =
        		employees.stream()
        		         .collect(Collectors.groupingBy(
        		        		 Employee::getGender,
        		        		 Collectors.averagingDouble(
        		        		 Employee::getSalary
        		          )));
        
        System.out.println(AvgSalaryByGender);
        System.out.println("___________________________________________________________________________________________________________________________________________");
    	
        
        System.out.println("\n12. Employee Name according to department \n");
        Map<String, List<String>> employeeName =
        		employees.stream()
        		.collect(Collectors.groupingBy(
        				Employee::getDepartment,
        				Collectors.mapping(Employee::getName, Collectors.toList())
        		));
        System.out.println(employeeName);
        System.out.println("___________________________________________________________________________________________________________________________________________");
    	
        
       System.out.println("\n13. Average and total Salary \n");
       double totalSalary =
    		   employees.stream()
    		    		.mapToDouble(Employee::getSalary)
    		    		.sum();
        double averageSalary =
        		employees.stream()
        				 .mapToDouble(Employee::getSalary)
        				 .average()
        				 .orElse(0);
        
        System.out.println("Total Salary : "+ totalSalary);
        System.out.println("Average Salary : "+ averageSalary);
        System.out.println("___________________________________________________________________________________________________________________________________________");
    	
        
        System.out.println("\n14. Employee with salary > 25K \n");
        employees.stream()
                 .filter(e-> e.getSalary() > 25000)
                 .forEach(System.out::println);
        System.out.println("___________________________________________________________________________________________________________________________________________");
    	
        
	    System.out.println("\n15. Highest Paid Employee \n");
	    Optional<Employee> highestPaid = 
	    		employees.stream()
	    				 .max(Comparator.comparing(Employee::getSalary));
	    highestPaid.ifPresent(System.out::println);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
        
        
	    System.out.println("\n16. Second Highest Paid Employee \n");
	    employees.stream()
	             .sorted(Comparator.comparing(Employee::getSalary).reversed())
	             .skip(1)
	             .findFirst()
	             .ifPresent(System.out::println);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
		
	    
	    System.out.println("\n17. third Highest Paid Employee \n");
	    employees.stream()
	             .sorted(Comparator.comparing(Employee::getSalary).reversed())
	             .skip(2)
	             .findFirst()
	             .ifPresent(System.out::println);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
		
	    
	    System.out.println("\n18. Highest Paid Employee \n");
	    Optional<Employee> lowestPaid = 
	    		employees.stream()
	    				 .min(Comparator.comparing(Employee::getSalary));
	    lowestPaid.ifPresent(System.out::println);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
		
	    
	    System.out.println("\n19. Second Lowest Paid Employee \n");
	    employees.stream()
	             .sorted(Comparator.comparing(Employee::getSalary))
	             .skip(1)
	             .findFirst()
	             .ifPresent(System.out::println);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
		
	    
	    System.out.println("\n20. Lowest Paid 5 Employees \n");
	    employees.stream()
	             .sorted(Comparator.comparing(Employee::getSalary))
	             .limit(5)
	             .forEach(System.out::println);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
	    
	    
	    System.out.println("\n21. Highest Paid 5 Employees \n");
	    employees.stream()
	             .sorted(Comparator.comparing(Employee::getSalary).reversed())
	             .limit(5)
	             .forEach(System.out::println);
	    System.out.println("___________________________________________________________________________________________________________________________________________");
	}
}
