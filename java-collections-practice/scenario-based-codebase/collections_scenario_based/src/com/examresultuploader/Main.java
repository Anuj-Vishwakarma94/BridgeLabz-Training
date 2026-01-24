package com.examresultuploader;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println(" ExamResultUploader – Marks Processor ");
        System.out.println("======================================");

        System.out.print("Enter marks CSV file path: ");
        String filePath = sc.nextLine();

        Map<String, List<Integer>> subjectMarks = new HashMap<>();

        Pattern validPattern = Pattern.compile("^\\d+,[A-Za-z ]+,[A-Za-z ]+,\\d{1,3}$");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                try {
                    processLine(line, subjectMarks, validPattern);
                } catch (InvalidMarksException e) {
                    System.out.println("Skipped invalid record: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        System.out.println("\n===== Subject-wise Top Scorers =====");

        subjectMarks.forEach((subject, marksList) -> {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            pq.addAll(marksList);

            if (!pq.isEmpty()) {
                System.out.println(subject + " → Top Score: " + pq.poll());
            }
        });

        sc.close();
    }

    static void processLine(String line,
                            Map<String, List<Integer>> subjectMarks,
                            Pattern pattern) throws InvalidMarksException {

        Matcher matcher = pattern.matcher(line);

        if (!matcher.matches()) {
            throw new InvalidMarksException("Invalid format → " + line);
        }

        String[] parts = line.split(",");

        String subject = parts[2];
        int marks;

        try {
            marks = Integer.parseInt(parts[3]);
        } catch (Exception e) {
            throw new InvalidMarksException("Invalid marks value → " + line);
        }

        subjectMarks.putIfAbsent(subject, new ArrayList<>());
        subjectMarks.get(subject).add(marks);
    }
}