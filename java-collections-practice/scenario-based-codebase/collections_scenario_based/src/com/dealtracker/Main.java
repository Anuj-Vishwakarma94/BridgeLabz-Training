package com.dealtracker;
import java.io.*;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" DealTracker – Discount Validator ");
        System.out.println("====================================");

        System.out.print("Enter deals TXT file path: ");
        String filePath = sc.nextLine();

        Map<String, Deal> validDeals = new HashMap<>();
        Set<String> usedCodes = new HashSet<>();

        Pattern codeP = Pattern.compile("DealCode:\\s*(.*)");
        Pattern dateP = Pattern.compile("ValidTill:\\s*(\\d{2}-\\d{2}-\\d{4})");
        Pattern discountP = Pattern.compile("Discount:\\s*(\\d+)%");
        Pattern minP = Pattern.compile("MinimumPurchase:\\s*(\\d+)");

        try (FileInputStream fis = new FileInputStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {

            String line;
            String code = null;
            LocalDate validTill = null;
            Integer discount = null;
            Integer minPurchase = null;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            List<String> allLines = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                allLines.add(line);
            }

            for (int i = 0; i < allLines.size(); i++) {
                line = allLines.get(i);

                Matcher m;

                m = codeP.matcher(line);
                if (m.matches()) code = m.group(1);

                m = dateP.matcher(line);
                if (m.matches()) validTill = LocalDate.parse(m.group(1), formatter);

                m = discountP.matcher(line);
                if (m.matches()) discount = Integer.parseInt(m.group(1));

                m = minP.matcher(line);
                if (m.matches()) minPurchase = Integer.parseInt(m.group(1));

                // Save deal when blank line OR last line
                if (line.trim().isEmpty() || i == allLines.size() - 1) {

                    if (code != null && validTill != null && discount != null && minPurchase != null) {

                        if (!usedCodes.contains(code) && validTill.isAfter(LocalDate.now())) {
                            Deal deal = new Deal(code, validTill, discount, minPurchase);
                            validDeals.put(code, deal);
                            usedCodes.add(code);
                        }
                    }

                    code = null;
                    validTill = null;
                    discount = null;
                    minPurchase = null;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        List<Deal> sortedDeals = new ArrayList<>(validDeals.values());
        sortedDeals.sort(Comparator.comparingInt(Deal::getDiscount).reversed());

        System.out.println("\n===== Valid Deals (Sorted by Discount) =====");

        if (sortedDeals.isEmpty()) {
            System.out.println("No valid deals found.");
        } else {
            sortedDeals.forEach(System.out::println);
        }

        sc.close();
    }
}