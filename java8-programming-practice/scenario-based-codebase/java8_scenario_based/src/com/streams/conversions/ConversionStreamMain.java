package com.streams.conversions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConversionStreamMain {

	public static void main(String[] args) {

        List<String> words = Arrays.asList("java", "spring", "boot", "java");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3);

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Anuj", "IT", 50000),
                new Employee(2, "Aryan", "HR", 45000),
                new Employee(3, "Andrew", "IT", 70000),
                new Employee(4, "Raghav", "Sales", 60000),
                new Employee(5, "Tristan", "Sales", 55000)
        );

        System.out.println("\n*** LIST → MAP CONVERSIONS ***");

        System.out.println("\n1. String → Length Map\n");
        System.out.println(words.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (a, b) -> a
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n2. Number → Square Map\n");
        System.out.println(numbers.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        n -> n * n,
                        (a, b) -> a
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n3. Employee ID → Name Map\n");
        System.out.println(employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getName
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n4. Word → Frequency Map\n");
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n5. Index → Element Map\n");
        System.out.println(IntStream.range(0, words.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> i,
                        words::get
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n6. Custom Key Field Map (Name → Salary)\n");
        System.out.println(employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n7. Handle Duplicate Keys\n");
        System.out.println(words.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (oldVal, newVal) -> oldVal
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n8. Keep First Duplicate\n");
        System.out.println(words.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (a, b) -> a
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n9. Keep Last Duplicate\n");
        System.out.println(words.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (a, b) -> b
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n10. Group By String Length\n");
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length)));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n*** MAP → LIST CONVERSIONS ***");

        Map<String, Integer> sampleMap = new HashMap<>();
        sampleMap.put("A", 10);
        sampleMap.put("B", 20);
        sampleMap.put("C", 15);

        System.out.println("\n1. Map Keys → List\n");
        System.out.println(new ArrayList<>(sampleMap.keySet()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n2. Map Values → List\n");
        System.out.println(new ArrayList<>(sampleMap.values()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n3. Map Entries → List\n");
        System.out.println(new ArrayList<>(sampleMap.entrySet()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n4. Key-Value String List\n");
        sampleMap.entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n5. Map → List of DTO\n");
        sampleMap.entrySet()
                .stream()
                .map(e -> new DTO(e.getKey(), e.getValue()))
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n6. Sorted by Key\n");
        sampleMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n7. Sorted by Value\n");
        sampleMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n8. Filter Value > 15\n");
        sampleMap.entrySet()
                .stream()
                .filter(e -> e.getValue() > 15)
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n9. Keys Where Value Even\n");
        sampleMap.entrySet()
                .stream()
                .filter(e -> e.getValue() % 2 == 0)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n10. Entries → DTO List\n");
        sampleMap.entrySet()
                .stream()
                .map(e -> new DTO(e.getKey(), e.getValue()))
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n*** LIST ↔ SET CONVERSIONS ***");

        System.out.println("\n1. List → Set\n");
        System.out.println(new HashSet<>(numbers));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n2. List → LinkedHashSet\n");
        System.out.println(new LinkedHashSet<>(numbers));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n3. List → TreeSet\n");
        System.out.println(new TreeSet<>(numbers));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n4. Set → List\n");
        Set<Integer> set1 = new HashSet<>(numbers);
        System.out.println(new ArrayList<>(set1));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n5. Set → Sorted List\n");
        System.out.println(set1.stream().sorted().collect(Collectors.toList()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n6. Object Set → Name List\n");
        System.out.println(employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n7. Filtered List → Set\n");
        System.out.println(numbers.stream()
                .filter(n -> n > 2)
                .collect(Collectors.toSet()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n8. Squares → Set\n");
        System.out.println(numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toSet()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n9. Set → Reverse List\n");
        set1.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n10. Merge Two Lists → Set\n");
        List<Integer> other = Arrays.asList(6, 7, 3, 2);
        System.out.println(
                Stream.concat(numbers.stream(), other.stream())
                        .collect(Collectors.toSet())
        );
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n*** ARRAY ↔ COLLECTION CONVERSIONS ***");

        String[] arr = {"java", "spring", "boot"};

        System.out.println("\n1. Array → List\n");
        System.out.println(Arrays.stream(arr).collect(Collectors.toList()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n2. Array → Set\n");
        System.out.println(Arrays.stream(arr).collect(Collectors.toSet()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n3. List → Array\n");
        System.out.println(Arrays.toString(words.toArray()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n4. Set → Array\n");
        System.out.println(Arrays.toString(set1.toArray()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n5. int[] → List<Integer>\n");
        int[] intArr = {1, 2, 3, 4};
        System.out.println(Arrays.stream(intArr).boxed().collect(Collectors.toList()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n6. String[] → List<String>\n");
        System.out.println(Arrays.asList(arr));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n7. Array → Index Map\n");
        System.out.println(IntStream.range(0, arr.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> arr[i])));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n8. 2D Array → Flat List\n");
        Integer[][] matrix = {{1, 2}, {3, 4}, {5}};
        System.out.println(Arrays.stream(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n9. Array → Value Map\n");
        System.out.println(Arrays.stream(arr)
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n10. Array → Distinct List\n");
        String[] arr2 = {"java", "spring", "java"};
        System.out.println(Arrays.stream(arr2)
                .distinct()
                .collect(Collectors.toList()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n*** OBJECT COLLECTION CONVERSIONS ***");

        System.out.println("\n1. Employees → Map<ID, Employee>\n");
        System.out.println(employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Function.identity()
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n2. Employees → Map<Dept, List<Employee>>\n");
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept)));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n3. Employees → Set of Departments\n");
        System.out.println(employees.stream()
                .map(Employee::getDept)
                .collect(Collectors.toSet()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n4. Objects → Field List\n");
        System.out.println(employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n5. Objects → Grouped Map\n");
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept)));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n6. Map Objects → Name List\n");
        System.out.println(employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n7. Salary By Name Map\n");
        System.out.println(employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n8. Nested List → Flat List\n");
        List<List<Employee>> nested = Arrays.asList(employees, employees);
        nested.stream()
              .flatMap(List::stream)
              .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n9. Employees → Dept Total Salary\n");
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.summingDouble(Employee::getSalary)
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n10. Composite Key Map\n");
        System.out.println(employees.stream()
                .collect(Collectors.toMap(
                        e -> e.getName() + "-" + e.getDept(),
                        Employee::getSalary
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n*** OTHER USEFUL CONVERSIONS ***");

        System.out.println("\n1. Stream → List\n");
        System.out.println(words.stream().toList());
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n2. Stream → Set\n");
        System.out.println(words.stream().collect(Collectors.toSet()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n3. Stream → Map\n");
        System.out.println(words.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (a, b) -> a
                )));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n4. Optional → List\n");
        Optional<String> opt = Optional.of("java");
        System.out.println(opt.stream().collect(Collectors.toList()));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n5. List → Comma String\n");
        System.out.println(String.join(",", words));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n6. List → JSON-like String\n");
        System.out.println(words.stream()
                .map(w -> "\"" + w + "\"")
                .collect(Collectors.joining(",", "[", "]")));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n7. Map → Comma String\n");
        System.out.println(sampleMap.entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(",")));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n8. List → Grouped Map\n");
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length)));
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n9. Grouped Map → List\n");
        words.stream()
             .collect(Collectors.groupingBy(String::length))
             .values()
             .stream()
             .flatMap(List::stream)
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n10. Partitioned Map → Two Lists\n");
        Map<Boolean, List<Integer>> part =
                numbers.stream()
                       .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even: " + part.get(true));
        System.out.println("Odd: " + part.get(false));
        System.out.println("________________________________________________________________________________________________");
    }
}

