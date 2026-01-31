package com.methodreferences.nameuppercase;

import java.util.*;
import java.util.stream.Collectors;

public class NameUppercase {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Anuj", "Andrew", "tristan");

        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        upperNames.forEach(System.out::println);
    }
}
