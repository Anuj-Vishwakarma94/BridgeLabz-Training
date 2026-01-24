package com.resumeanalyzer;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    static final List<String> KEYWORDS = Arrays.asList("Java", "Python", "Spring");

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" ResumeAnalyzer – HireRight Tech ");
        System.out.println("=================================");

        System.out.print("Enter resumes folder path: ");
        String folderPath = sc.nextLine();

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return;
        }

        Map<String, ResumeData> resumeMap = new HashMap<>();
        List<ResumeData> sortedList = new ArrayList<>();

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No resumes found.");
            return;
        }

        for (File file : files) {
            try {
                if (!file.getName().endsWith(".txt")) {
                    throw new Exception("Unsupported file format");
                }

                String content = readFile(file);

                String email = extractEmail(content);
                String phone = extractPhone(content);
                List<String> matched = extractKeywords(content);

                if (email == null) {
                    throw new Exception("Invalid resume (no email)");
                }

                ResumeData data = new ResumeData(email, phone, matched);
                resumeMap.put(email, data);
                sortedList.add(data);

            } catch (Exception e) {
                System.out.println("Skipped: " + file.getName() + " -> " + e.getMessage());
            }
        }

        sortedList.sort((a, b) -> b.getKeywordCount() - a.getKeywordCount());

        System.out.println("\n===== Ranked Candidates =====");
        for (ResumeData r : sortedList) {
            r.display();
        }
    }

    // Read file content using I/O Streams
    static String readFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append(" ");
        }

        br.close();
        return sb.toString();
    }

    // Regex: Email extraction
    static String extractEmail(String text) {
        Pattern p = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}");
        Matcher m = p.matcher(text);
        return m.find() ? m.group() : null;
    }

    // Regex: Phone extraction
    static String extractPhone(String text) {
        Pattern p = Pattern.compile("\\b\\d{10}\\b");
        Matcher m = p.matcher(text);
        return m.find() ? m.group() : "Not Found";
    }

    // Extract keywords
    static List<String> extractKeywords(String text) {
        List<String> found = new ArrayList<>();

        for (String keyword : KEYWORDS) {
            Pattern p = Pattern.compile("\\b" + keyword + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(text);

            if (m.find()) {
                found.add(keyword);
            }
        }
        return found;
    }
}