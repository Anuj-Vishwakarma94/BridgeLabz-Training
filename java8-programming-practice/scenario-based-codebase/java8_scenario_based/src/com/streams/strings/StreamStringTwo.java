package com.streams.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamStringTwo {

    public static void main(String[] args) {

        System.out.println("\n1. Character Frequency Count\n");
        String s1 = "banana";

        Map<Character, Long> charFreq =
                s1.chars()
                  .mapToObj(c -> (char) c)
                  .collect(Collectors.groupingBy(
                          Function.identity(),
                          Collectors.counting()
                  ));

        System.out.println(charFreq);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n2. Word Frequency Count\n");
        String s2 = "java is java and java is fast";

        Map<String, Long> wordFreq =
                Arrays.stream(s2.split(" "))
                      .collect(Collectors.groupingBy(
                              Function.identity(),
                              Collectors.counting()
                      ));

        System.out.println(wordFreq);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n3. First Non-Repeating Character\n");
        String s3 = "stress";

        s3.chars()
          .mapToObj(c -> (char) c)
          .filter(c -> s3.indexOf(c) == s3.lastIndexOf(c))
          .findFirst()
          .ifPresent(System.out::println);

        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n4. All Non-Repeating Characters\n");
        String s4 = "programming";

        s4.chars()
          .mapToObj(c -> (char) c)
          .filter(c -> s4.indexOf(c) == s4.lastIndexOf(c))
          .forEach(System.out::println);

        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n5. Remove Duplicate Characters\n");
        String s5 = "banana";

        String result1 =
                s5.chars()
                  .mapToObj(c -> (char) c)
                  .distinct()
                  .map(String::valueOf)
                  .collect(Collectors.joining());

        System.out.println(result1);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n6. Remove Repeating Characters (Keep Only Unique Once)\n");
        String s6 = "aabbccdde";

        String result2 =
                s6.chars()
                  .mapToObj(c -> (char) c)
                  .filter(c -> s6.indexOf(c) == s6.lastIndexOf(c))
                  .map(String::valueOf)
                  .collect(Collectors.joining());

        System.out.println(result2);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n7. Remove Non-Alphanumeric Characters\n");
        String s7 = "ja@va#8!!";

        String result3 =
                s7.chars()
                  .mapToObj(c -> (char) c)
                  .filter(Character::isLetterOrDigit)
                  .map(String::valueOf)
                  .collect(Collectors.joining());

        System.out.println(result3);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n8. Keep Only Alphabets\n");
        String s8 = "java8stream2025";

        String result4 =
                s8.chars()
                  .mapToObj(c -> (char) c)
                  .filter(Character::isLetter)
                  .map(String::valueOf)
                  .collect(Collectors.joining());

        System.out.println(result4);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n9. Keep Only Digits\n");
        String s9 = "orderId=AB123XZ9";

        String result5 =
                s9.chars()
                  .mapToObj(c -> (char) c)
                  .filter(Character::isDigit)
                  .map(String::valueOf)
                  .collect(Collectors.joining());

        System.out.println(result5);
        System.out.println("________________________________________________________________________________________________");


        System.out.println("\n10. Count Each Character Except Spaces\n");
        String s10 = "java stream";

        Map<Character, Long> freqWithoutSpaces =
                s10.chars()
                   .mapToObj(c -> (char) c)
                   .filter(c -> c != ' ')
                   .collect(Collectors.groupingBy(
                           Function.identity(),
                           Collectors.counting()
                   ));

        System.out.println(freqWithoutSpaces);
        System.out.println("________________________________________________________________________________________________");
    }
}

