package com.medinventory;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" MedInventory – Hospital Tracker ");
        System.out.println("====================================");

        System.out.print("Enter inventory CSV file path: ");
        String filePath = sc.nextLine();

        Set<Item<?>> uniqueItems = new HashSet<>();
        Map<String, List<Item<?>>> categorized = new HashMap<>();

        categorized.put("Valid", new ArrayList<>());
        categorized.put("Expired", new ArrayList<>());

        Pattern datePattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                try {
                    processLine(line, uniqueItems, categorized, datePattern);
                } catch (Exception e) {
                    System.out.println("Skipped invalid line: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        System.out.println("\n===== Inventory Summary =====");

        categorized.forEach((category, list) -> {
            System.out.println("\n" + category + " Items:");
            list.forEach(System.out::println);
        });

        sc.close();
    }

    static void processLine(String line,
                            Set<Item<?>> uniqueItems,
                            Map<String, List<Item<?>>> categorized,
                            Pattern datePattern) throws Exception {

        String[] parts = line.split(",");

        if (parts.length != 4) {
            throw new RuntimeException("Invalid CSV format");
        }

        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        int qty = Integer.parseInt(parts[2]);
        String expiry = parts[3];

        Matcher matcher = datePattern.matcher(expiry);

        if (!matcher.matches()) {
            throw new RuntimeException("Invalid date format");
        }

        Item<?> item = new Item<>(id, name, qty, expiry);

        if (!uniqueItems.add(item)) {
            return; // Duplicate ignored
        }

        checkLowStock(item);

        if (isExpired(expiry)) {
            categorized.get("Expired").add(item);
        } else {
            categorized.get("Valid").add(item);
        }
    }

    // Custom Exception trigger
    static void checkLowStock(Item<?> item) throws LowStockException {
        if (item.getQuantity() <= 2) {
            throw new LowStockException("CRITICAL LOW STOCK: " + item.getName());
        }
    }

    // Expiry detection
    static boolean isExpired(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate expiryDate = LocalDate.parse(date, formatter);
        return expiryDate.isBefore(LocalDate.now());
    }
}