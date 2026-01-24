package com.examscanner;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    static final String ANSWER_KEY = "A,B,C,D,A,B,C";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" ExamScanner – Answer Validator ");
        System.out.println("=================================");

        System.out.print("Enter CSV file path: ");
        String filePath = sc.nextLine();

        Map<String, Integer> scores = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> ranking =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        Pattern validPattern = Pattern.compile("^([A-Za-z ]+),([A-D],){6}[A-D]$");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                try {
                    processLine(line, scores, validPattern);
                } catch (Exception e) {
                    System.out.println("Skipped invalid line: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        ranking.addAll(scores.entrySet());

        System.out.println("\n===== Student Rankings =====");

        while (!ranking.isEmpty()) {
            var entry = ranking.poll();
            System.out.println(entry.getKey() + " → Score: " + entry.getValue());
        }

        sc.close();
    }

    // Process each CSV line
    static void processLine(String line, Map<String, Integer> scores, Pattern pattern) {

        Matcher matcher = pattern.matcher(line);

        if (!matcher.matches()) {
            throw new RuntimeException("Invalid format");
        }

        String[] parts = line.split(",");
        String name = parts[0];

        String[] studentAnswers = Arrays.copyOfRange(parts, 1, parts.length);
        String[] correctAnswers = ANSWER_KEY.split(",");

        int score = 0;

        for (int i = 0; i < correctAnswers.length; i++) {
            if (studentAnswers[i].equals(correctAnswers[i])) {
                score++;
            }
        }

        scores.put(name, score);
    }
}