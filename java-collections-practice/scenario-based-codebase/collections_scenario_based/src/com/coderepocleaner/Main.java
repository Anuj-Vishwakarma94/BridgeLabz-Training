package com.coderepocleaner;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {

    static Pattern badMethodPattern = Pattern.compile("\\b[A-Z][a-zA-Z0-9]*\\s*\\(");
    static Pattern importPattern = Pattern.compile("^import\\s+([\\w\\.]+);", Pattern.MULTILINE);

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" CodeRepoCleaner – Java Scanner ");
        System.out.println("=================================");

        System.out.print("Enter project folder path:(type src/com/coderepocleaner/samplejavafiles)");
        String inputFolder = sc.nextLine();

        List<Path> javaFiles = Files.walk(Paths.get(inputFolder))
                .filter(p -> p.toString().endsWith(".java"))
                .collect(Collectors.toList());

        Map<FileType, List<File>> categorized = new HashMap<>();
        categorized.put(FileType.VALID, new ArrayList<>());
        categorized.put(FileType.WARNINGS, new ArrayList<>());
        categorized.put(FileType.ERRORS, new ArrayList<>());

        for (Path p : javaFiles) {
            analyzeFile(p.toFile(), categorized);
        }

        System.out.println("\n===== Scan Summary =====");
        categorized.forEach((type, files) -> {
            System.out.println(type + " → " + files.size() + " files");
        });

        filterLargeFiles(javaFiles);
        organizeFiles(categorized, inputFolder);

        sc.close();
    }

    // Analyze Java file
    static void analyzeFile(File file, Map<FileType, List<File>> categorized) {
        try {
            String content = Files.readString(file.toPath());

            boolean badMethod = detectBadMethodNames(content);
            boolean unusedImport = detectUnusedImports(content);

            if (badMethod) {
                categorized.get(FileType.ERRORS).add(file);
            } 
            else if (unusedImport) {
                categorized.get(FileType.WARNINGS).add(file);
            } 
            else {
                categorized.get(FileType.VALID).add(file);
            }

        } catch (Exception e) {
            categorized.get(FileType.ERRORS).add(file);
        }
    }

    // Regex: detect bad method naming
    static boolean detectBadMethodNames(String text) {
        Matcher m = badMethodPattern.matcher(text);
        return m.find();
    }

    // Regex: detect unused imports
    static boolean detectUnusedImports(String text) {
        Set<String> imports = new HashSet<>();
        Matcher m = importPattern.matcher(text);

        while (m.find()) {
            imports.add(m.group(1));
        }

        for (String imp : imports) {
            String className = imp.substring(imp.lastIndexOf(".") + 1);
            if (!text.contains(className + ".")) {
                return true;
            }
        }
        return false;
    }

    // Streams: filter large files
    static void filterLargeFiles(List<Path> files) {
        System.out.println("\nLarge Java Files (>5KB):");

        files.stream()
                .filter(p -> p.toFile().length() > 5000)
                .forEach(p -> System.out.println(p.getFileName()));
    }

    // Create folders in com/coderepocleaner and move files
    static void organizeFiles(Map<FileType, List<File>> categorized, String inputFolder) throws IOException {

        Path baseDir = Paths.get(inputFolder).getParent(); 
        // one level up → com/coderepocleaner

        Path validDir = baseDir.resolve("Valid");
        Path warningDir = baseDir.resolve("Warnings");
        Path errorDir = baseDir.resolve("Errors");

        Files.createDirectories(validDir);
        Files.createDirectories(warningDir);
        Files.createDirectories(errorDir);

        moveFiles(categorized.get(FileType.VALID), validDir);
        moveFiles(categorized.get(FileType.WARNINGS), warningDir);
        moveFiles(categorized.get(FileType.ERRORS), errorDir);

        System.out.println("\nFolders created inside: " + baseDir);
    }

    static void moveFiles(List<File> files, Path targetFolder) throws IOException {
        for (File f : files) {
            Files.copy(f.toPath(),
                    targetFolder.resolve(f.getName()),
                    StandardCopyOption.REPLACE_EXISTING);
        }
    }
}