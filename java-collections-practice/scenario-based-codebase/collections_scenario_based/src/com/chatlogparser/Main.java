package com.chatlogparser;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" ChatLogParser – Message Analyzer ");
        System.out.println("=================================");

        System.out.print("Enter chat log file path: ");
        String filePath = sc.nextLine();

        TreeMap<String, List<String>> userMessages = new TreeMap<>();

        Pattern pattern = Pattern.compile("\\[(.*?)\\]\\s+(.*?):\\s+(.*)");

        MessageFilter<String> filter = new IdleMessageFilter();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                try {
                    parseLine(line, userMessages, pattern, filter);
                } catch (Exception e) {
                    System.out.println("Skipped invalid line: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        System.out.println("\n===== Chat Summary =====");

        userMessages.forEach((user, messages) -> {
            System.out.println("\n" + user + ":");
            messages.forEach(msg -> System.out.println(" - " + msg));
        });

        sc.close();
    }

    static void parseLine(String line,
                          TreeMap<String, List<String>> userMessages,
                          Pattern pattern,
                          MessageFilter<String> filter) {

        Matcher matcher = pattern.matcher(line);

        if (!matcher.matches()) {
            throw new RuntimeException("Invalid chat format");
        }

        String timestamp = matcher.group(1);
        String user = matcher.group(2);
        String message = matcher.group(3);

        if (!filter.allow(message)) {
            return; // Skip idle chat
        }

        userMessages.putIfAbsent(user, new ArrayList<>());
        userMessages.get(user).add("[" + timestamp + "] " + message);
    }
}