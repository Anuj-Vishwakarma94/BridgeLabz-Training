package com.streams.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamStringOne {

    public static void main(String[] args) {

        System.out.println("\n1. Count vowels in a string\n");
        String s1 = "programming";
        long vowelCount =
                s1.chars()
                  .mapToObj(c -> (char) c)
                  .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                  .count();
        System.out.println(vowelCount);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n2. Count number of words in a sentence\n");
        String sentence = "Java is very powerful";
        long wordCount =
                Arrays.stream(sentence.split(" "))
                      .count();
        System.out.println(wordCount);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n3. Find even numbers from list\n");
        List<Integer> nums1 = Arrays.asList(2, 5, 7, 8, 10, 13);
        nums1.stream()
             .filter(n -> n % 2 == 0)
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n4. Convert list of strings to uppercase\n");
        List<String> list1 = Arrays.asList("java", "spring", "boot");
        list1.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n5. Find string length list\n");
        List<String> list2 = Arrays.asList("cat", "elephant", "dog");
        list2.stream()
             .map(String::length)
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n6. Count strings starting with 'a'\n");
        List<String> list3 = Arrays.asList("apple", "banana", "ant", "car");
        long countA =
                list3.stream()
                     .filter(str -> str.startsWith("a"))
                     .count();
        System.out.println(countA);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n7. Remove empty strings\n");
        List<String> list4 = Arrays.asList("java", "", "spring", "", "boot");
        list4.stream()
             .filter(str -> !str.isEmpty())
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n8. Sum of all numbers\n");
        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5);
        int sum =
                nums2.stream()
                     .mapToInt(Integer::intValue)
                     .sum();
        System.out.println(sum);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n9. Find max number\n");
        List<Integer> nums3 = Arrays.asList(10, 25, 3, 99, 45);
        nums3.stream()
             .max(Integer::compareTo)
             .ifPresent(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n10. Reverse each string in list\n");
        List<String> list5 = Arrays.asList("java", "api");
        list5.stream()
             .map(str -> new StringBuilder(str).reverse().toString())
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n11. Remove duplicate elements\n");
        List<Integer> nums4 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        nums4.stream()
             .distinct()
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n12. Sort list in descending order\n");
        List<Integer> nums5 = Arrays.asList(5, 1, 9, 3);
        nums5.stream()
             .sorted(Comparator.reverseOrder())
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n13. Find second highest number\n");
        List<Integer> nums6 = Arrays.asList(10, 40, 30, 20);
        nums6.stream()
             .sorted(Comparator.reverseOrder())
             .skip(1)
             .findFirst()
             .ifPresent(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n14. Join strings with comma\n");
        List<String> list6 = Arrays.asList("Java", "Spring", "Boot");
        String joined =
                list6.stream()
                     .collect(Collectors.joining(","));
        System.out.println(joined);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n15. Frequency of each character\n");
        String s2 = "banana";
        Map<Character, Long> charFreq =
                s2.chars()
                  .mapToObj(c -> (char) c)
                  .collect(Collectors.groupingBy(
                          Function.identity(),
                          Collectors.counting()
                  ));
        System.out.println(charFreq);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n16. Find numbers greater than 50\n");
        List<Integer> nums7 = Arrays.asList(10, 55, 60, 23, 90);
        nums7.stream()
             .filter(n -> n > 50)
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n17. Group strings by length\n");
        List<String> list7 = Arrays.asList("a", "bb", "ccc", "dd");
        Map<Integer, List<String>> groupedByLength =
                list7.stream()
                     .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n18. First non-repeated character\n");
        String s3 = "stress";
        s3.chars()
          .mapToObj(c -> (char) c)
          .filter(c -> s3.indexOf(c) == s3.lastIndexOf(c))
          .findFirst()
          .ifPresent(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n19. Convert List<Integer> to List<String>\n");
        List<Integer> nums8 = Arrays.asList(1, 2, 3);
        nums8.stream()
             .map(String::valueOf)
             .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n20. Count occurrences of each word\n");
        String s4 = "java is java and java is fast";
        Map<String, Long> wordFreq =
                Arrays.stream(s4.split(" "))
                      .collect(Collectors.groupingBy(
                              Function.identity(),
                              Collectors.counting()
                      ));
        System.out.println(wordFreq);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n21. Partition numbers into even and odd\n");
        List<Integer> nums9 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned =
                nums9.stream()
                     .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n22. Find duplicate elements only\n");
        List<Integer> nums10 = Arrays.asList(1, 2, 3, 2, 4, 5, 1);
        nums10.stream()
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
              .entrySet()
              .stream()
              .filter(e -> e.getValue() > 1)
              .map(Map.Entry::getKey)
              .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n23. Find longest string\n");
        List<String> list8 = Arrays.asList("java", "microservices", "api");
        list8.stream()
             .max(Comparator.comparingInt(String::length))
             .ifPresent(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n24. Find top 3 highest numbers\n");
        List<Integer> nums11 = Arrays.asList(10, 90, 30, 70, 50);
        nums11.stream()
              .sorted(Comparator.reverseOrder())
              .limit(3)
              .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n25. Flatten list of lists\n");
        List<List<Integer>> nested =
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(3, 4),
                        Arrays.asList(5)
                );
        nested.stream()
              .flatMap(List::stream)
              .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n26. Sum of squares of even numbers\n");
        List<Integer> nums12 = Arrays.asList(1, 2, 3, 4, 5);
        int squareSum =
                nums12.stream()
                      .filter(n -> n % 2 == 0)
                      .map(n -> n * n)
                      .mapToInt(Integer::intValue)
                      .sum();
        System.out.println(squareSum);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n27. Sort map by value\n");
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 3);
        map.put("B", 1);
        map.put("C", 2);

        map.entrySet()
           .stream()
           .sorted(Map.Entry.comparingByValue())
           .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n28. Find common elements between two lists\n");
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> l2 = Arrays.asList(3, 4, 5, 6);

        l1.stream()
          .filter(l2::contains)
          .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n29. Find kth smallest element\n");
        List<Integer> nums13 = Arrays.asList(9, 1, 5, 3, 7);
        int k = 2;

        nums13.stream()
              .sorted()
              .skip(k - 1)
              .findFirst()
              .ifPresent(System.out::println);
        System.out.println("________________________________________________________________________________________________");
    }
}
