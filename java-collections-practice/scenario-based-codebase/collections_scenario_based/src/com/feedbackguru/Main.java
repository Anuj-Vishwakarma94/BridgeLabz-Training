package com.feedbackguru;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" FeedbackGuru – Smart Analyzer ");
        System.out.println("=================================");

        System.out.print("Enter feedback folder path: ");
        String folderPath = sc.nextLine();

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return;
        }

        Map<String, List<String>> categorized = new HashMap<>();

        categorized.put("Positive", new ArrayList<>());
        categorized.put("Neutral", new ArrayList<>());
        categorized.put("Negative", new ArrayList<>());

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No feedback files found.");
            return;
        }

        for (File file : files) {
            processFile(file, categorized);
        }

        System.out.println("\n===== Feedback Summary =====");

        categorized.forEach((category, list) -> {
            System.out.println("\n" + category + " Feedback:");
            if (list.isEmpty()) {
                System.out.println("None");
            } else {
                list.forEach(System.out::println);
            }
        });
    }

    // Read file and process lines
    static void processFile(File file, Map<String, List<String>> categorized) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                try {
                    analyzeLine(line, categorized);
                } catch (Exception e) {
                    System.out.println("Skipped invalid feedback: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }

    // Analyze feedback line using Regex
    static void analyzeLine(String line, Map<String, List<String>> categorized) {

        Pattern p = Pattern.compile("(\\d{1,2})/10");
        Matcher m = p.matcher(line);

        if (!m.find()) {
            throw new RuntimeException("No rating found");
        }

        int rating = Integer.parseInt(m.group(1));

        if (rating >= 8) {
            categorized.get("Positive").add(line);
        } else if (rating >= 5) {
            categorized.get("Neutral").add(line);
        } else {
            categorized.get("Negative").add(line);
        }
    }
}