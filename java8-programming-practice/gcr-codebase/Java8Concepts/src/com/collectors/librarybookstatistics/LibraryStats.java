package com.collectors.librarybookstatistics;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryStats {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("Fiction", 300),
                new Book("Fiction", 500),
                new Book("Science", 400),
                new Book("Science", 600)
        );

        Map<String, IntSummaryStatistics> statsByGenre =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));

        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Max Pages: " + stats.getMax());
            System.out.println();
        });
    }
}
