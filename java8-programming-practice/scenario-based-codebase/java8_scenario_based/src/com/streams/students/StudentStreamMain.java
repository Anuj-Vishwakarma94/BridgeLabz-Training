package com.streams.students;

import java.util.*;
import java.util.stream.Collectors;

public class StudentStreamMain {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();

		students.add(new Student(1, "Anuj", 22, "Male", "Mumbai", "Computer", 12, List.of("9000000001")));
		students.add(new Student(2, "Aryan", 24, "Male", "Delhi", "Mechanical", 45, List.of("9000000002", "9000000003")));
		students.add(new Student(3, "Andrew", 21, "Male", "Karnataka", "Electronics", 78, List.of("9000000004")));
		students.add(new Student(4, "Tristan", 26, "Male", "Mumbai", "Computer", 33, List.of("9000000005", "9000000006")));
		students.add(new Student(5, "Saurav", 23, "Male", "Delhi", "Biotech", 60, List.of("9000000007")));
		students.add(new Student(6, "Akshat", 25, "Male", "Karnataka", "Mechanical", 15, List.of("9000000008")));

		students.add(new Student(7, "Selena", 22, "Female", "Delhi", "Computer", 18, List.of("9000000009")));
		students.add(new Student(8, "Priya", 24, "Female", "Mumbai", "Mechanical", 35, List.of("9000000010")));
		students.add(new Student(9, "Ananya", 26, "Female", "Karnataka", "Electronics", 55, List.of("9000000011", "9000000012")));

		System.out.println("\n*** BASIC FILTERING & MAPPING ***");

		System.out.println("\n1. Print all students whose rank is less than 50 \n");
		students.stream()
				.filter(s -> s.getRank() < 50)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n2. Print all students whose age is greater than 25 \n");
		students.stream()
				.filter(s -> s.getAge() > 25)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n3. Print the names of all students only \n");
		students.stream()
				.map(Student::getFirstName)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n4. Print all students belonging to Mechanical Engineering \n");
		students.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("Mechanical"))
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n5. Print all students not from Mumbai \n");
		students.stream()
				.filter(s -> !s.getCity().equalsIgnoreCase("Mumbai"))
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n*** SORTING & LIMITING ***");

		System.out.println("\n6. Sort students by rank (ascending) \n");
		students.stream()
				.sorted(Comparator.comparing(Student::getRank))
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n7. Sort students by age (descending) \n");
		students.stream()
				.sorted(Comparator.comparing(Student::getAge).reversed())
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n8. Print top 5 students based on rank \n");
		students.stream()
				.sorted(Comparator.comparing(Student::getRank))
				.limit(5)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n9. Print last 3 students based on rank \n");
		students.stream()
				.sorted(Comparator.comparing(Student::getRank).reversed())
				.limit(3)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n10. Print students sorted by name and then rank \n");
		students.stream()
				.sorted(Comparator.comparing(Student::getFirstName)
						.thenComparing(Student::getRank))
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n*** GROUPING & AGGREGATION ***");

		System.out.println("\n11. Count the number of students in each department \n");
		Map<String, Long> deptCount =
				students.stream()
						.collect(Collectors.groupingBy(
								Student::getDepartment,
								Collectors.counting()
						));
		System.out.println(deptCount);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n12. Count the number of students in each city \n");
		Map<String, Long> cityCount =
				students.stream()
						.collect(Collectors.groupingBy(
								Student::getCity,
								Collectors.counting()
						));
		System.out.println(cityCount);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n13. Find the average age of students in each department \n");
		Map<String, Double> avgAgeDept =
				students.stream()
						.collect(Collectors.groupingBy(
								Student::getDepartment,
								Collectors.averagingInt(Student::getAge)
						));
		System.out.println(avgAgeDept);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n14. Find the average rank of students by gender \n");
		Map<String, Double> avgRankGender =
				students.stream()
						.collect(Collectors.groupingBy(
								Student::getGender,
								Collectors.averagingInt(Student::getRank)
						));
		System.out.println(avgRankGender);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n15. Find the total number of students in the organization \n");
		System.out.println(students.stream().count());
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n16. Find the department with the highest average rank \n");
		students.stream()
				.collect(Collectors.groupingBy(
						Student::getDepartment,
						Collectors.averagingInt(Student::getRank)
				))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n*** MIN / MAX / RANKING PROBLEMS ***");

		System.out.println("\n17. Find the student with the best rank \n");
		students.stream()
				.min(Comparator.comparing(Student::getRank))
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n18. Find the student with the worst rank \n");
		students.stream()
				.max(Comparator.comparing(Student::getRank))
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n19. Find the second best rank holder \n");
		students.stream()
				.sorted(Comparator.comparing(Student::getRank))
				.skip(1)
				.findFirst()
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n20. Find the third best rank holder \n");
		students.stream()
				.sorted(Comparator.comparing(Student::getRank))
				.skip(2)
				.findFirst()
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n21. Find the youngest student \n");
		students.stream()
				.min(Comparator.comparing(Student::getAge))
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n22. Find the oldest student \n");
		students.stream()
				.max(Comparator.comparing(Student::getAge))
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n*** FLATMAP & COLLECTIONS ***");

		System.out.println("\n23. Print all contact numbers of all students \n");
		students.stream()
				.flatMap(s -> s.getContacts().stream())
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n24. Count the total number of contact numbers \n");
		System.out.println(
				students.stream()
						.flatMap(s -> s.getContacts().stream())
						.count()
		);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n25. Find students who have more than one contact number \n");
		students.stream()
				.filter(s -> s.getContacts().size() > 1)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n26. Print unique contact numbers \n");
		students.stream()
				.flatMap(s -> s.getContacts().stream())
				.distinct()
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n*** CONDITIONAL & MATCHING ***");

		System.out.println("\n27. Check if any student belongs to Biotech Engineering \n");
		System.out.println(
				students.stream()
						.anyMatch(s -> s.getDepartment().equalsIgnoreCase("Biotech"))
		);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n28. Check if all students are above age 20 \n");
		System.out.println(
				students.stream()
						.allMatch(s -> s.getAge() > 20)
		);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n29. Check if no student belongs to Civil Engineering \n");
		System.out.println(
				students.stream()
						.noneMatch(s -> s.getDepartment().equalsIgnoreCase("Civil"))
		);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n*** GENDER-BASED ANALYSIS ***");

		System.out.println("\n30. Count male and female students \n");
		Map<String, Long> genderCount =
				students.stream()
						.collect(Collectors.groupingBy(
								Student::getGender,
								Collectors.counting()
						));
		System.out.println(genderCount);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n31. Find the average age of male students \n");
		students.stream()
				.filter(s -> s.getGender().equalsIgnoreCase("Male"))
				.mapToInt(Student::getAge)
				.average()
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n32. Find the average age of female students \n");
		students.stream()
				.filter(s -> s.getGender().equalsIgnoreCase("Female"))
				.mapToInt(Student::getAge)
				.average()
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n33. Find the highest ranked male student \n");
		students.stream()
				.filter(s -> s.getGender().equalsIgnoreCase("Male"))
				.min(Comparator.comparing(Student::getRank))
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n34. Find the highest ranked female student \n");
		students.stream()
				.filter(s -> s.getGender().equalsIgnoreCase("Female"))
				.min(Comparator.comparing(Student::getRank))
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n*** DEPARTMENT-SPECIFIC QUERIES ***");

		System.out.println("\n35. List students department-wise with names only \n");
		Map<String, List<String>> deptNames =
				students.stream()
						.collect(Collectors.groupingBy(
								Student::getDepartment,
								Collectors.mapping(Student::getFirstName, Collectors.toList())
						));
		System.out.println(deptNames);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n36. Find the youngest student in Computer Engineering \n");
		students.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("Computer"))
				.min(Comparator.comparing(Student::getAge))
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n37. Find the top-ranked student in Mechanical Engineering \n");
		students.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("Mechanical"))
				.min(Comparator.comparing(Student::getRank))
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n38. Count students in Electronics Engineering from Karnataka \n");
		System.out.println(
				students.stream()
						.filter(s -> s.getDepartment().equalsIgnoreCase("Electronics")
								&& s.getCity().equalsIgnoreCase("Karnataka"))
						.count()
		);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n*** ADVANCED LEVEL ***");

		System.out.println("\n39. Convert the student list into a Map<Id, Name> \n");
		Map<Integer, String> idNameMap =
				students.stream()
						.collect(Collectors.toMap(
								Student::getId,
								Student::getFirstName
						));
		System.out.println(idNameMap);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n40. Convert the student list into a Map<Department, List<Student>> \n");
		Map<String, List<Student>> deptStudentMap =
				students.stream()
						.collect(Collectors.groupingBy(Student::getDepartment));
		System.out.println(deptStudentMap);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n41. Find students whose name starts with 'S' \n");
		students.stream()
				.filter(s -> s.getFirstName().startsWith("S"))
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n42. Find students whose name length is greater than 5 \n");
		students.stream()
				.filter(s -> s.getFirstName().length() > 5)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n43. Find students whose rank is even \n");
		students.stream()
				.filter(s -> s.getRank() % 2 == 0)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n44. Find students whose rank is odd \n");
		students.stream()
				.filter(s -> s.getRank() % 2 != 0)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n*** BONUS CHALLENGES ***");

		System.out.println("\n45. Find the top 3 youngest students \n");
		students.stream()
				.sorted(Comparator.comparing(Student::getAge))
				.limit(3)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n46. Find the top 3 oldest students \n");
		students.stream()
				.sorted(Comparator.comparing(Student::getAge).reversed())
				.limit(3)
				.forEach(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n47. Partition students based on age > 25 \n");
		Map<Boolean, List<Student>> agePartition =
				students.stream()
						.collect(Collectors.partitioningBy(s -> s.getAge() > 25));
		System.out.println(agePartition);
		System.out.println("________________________________________________________________________________________________");

		System.out.println("\n48. Partition students based on rank < 100 \n");
		Map<Boolean, List<Student>> rankPartition =
				students.stream()
						.collect(Collectors.partitioningBy(s -> s.getRank() < 100));
		System.out.println(rankPartition);
		System.out.println("________________________________________________________________________________________________");

		
		System.out.println("\n49. Find the city having maximum students \n");
		students.stream()
				.collect(Collectors.groupingBy(
						Student::getCity,
						Collectors.counting()
				))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");

		
		System.out.println("\n50. Find the department having minimum students \n");
		students.stream()
				.collect(Collectors.groupingBy(
						Student::getDepartment,
						Collectors.counting()
				))
				.entrySet()
				.stream()
				.min(Map.Entry.comparingByValue())
				.ifPresent(System.out::println);
		System.out.println("________________________________________________________________________________________________");
	}
}
