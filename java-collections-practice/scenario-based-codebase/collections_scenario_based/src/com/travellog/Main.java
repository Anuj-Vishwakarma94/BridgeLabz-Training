package com.travellog;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

    static final String FILE_NAME = "trips.dat";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Trip> trips = loadTrips();

        System.out.println("=================================");
        System.out.println(" TravelLog – Ritika's Trip Diary ");
        System.out.println("=================================");

        while (true) {
            System.out.println("\n1. Add Trip");
            System.out.println("2. Show All Trips");
            System.out.println("3. Cities Visited (Regex)");
            System.out.println("4. Trips Longer Than 5 Days");
            System.out.println("5. Unique Countries Visited");
            System.out.println("6. Top 3 Most Visited Cities");
            System.out.println("7. Save & Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("Country: ");
                    String country = sc.nextLine();

                    System.out.print("Duration (days): ");
                    int days = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Notes: ");
                    String notes = sc.nextLine();

                    trips.add(new Trip(city, country, days, notes));
                    System.out.println("Trip added.");
                    break;

                case 2:
                    for (Trip t : trips) {
                        System.out.println(t);
                    }
                    break;

                case 3:
                    findCitiesRegex(trips);
                    break;

                case 4:
                    System.out.println("\nTrips longer than 5 days:");
                    for (Trip t : trips) {
                        if (t.getDurationDays() > 5) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 5:
                    showUniqueCountries(trips);
                    break;

                case 6:
                    showTopCities(trips);
                    break;

                case 7:
                    saveTrips(trips);
                    System.out.println("Trips saved. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    // Save trips using serialization
    static void saveTrips(ArrayList<Trip> trips) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(trips);
        } catch (IOException e) {
            System.out.println("Error saving trips.");
        }
    }

    // Load trips using deserialization
    static ArrayList<Trip> loadTrips() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Trip>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Regex city extraction from notes
    static void findCitiesRegex(ArrayList<Trip> trips) {
        Pattern p = Pattern.compile("\\b[A-Z][a-zA-Z]+\\b");
        Set<String> cities = new HashSet<>();

        for (Trip t : trips) {
            Matcher m = p.matcher(t.getNotes());
            while (m.find()) {
                cities.add(m.group());
            }
        }

        System.out.println("Cities found in notes: " + cities);
    }

    // Unique countries using Set
    static void showUniqueCountries(ArrayList<Trip> trips) {
        Set<String> countries = new HashSet<>();
        for (Trip t : trips) {
            countries.add(t.getCountry());
        }

        System.out.println("Unique countries visited: " + countries);
    }

    // Top 3 most visited cities
    static void showTopCities(ArrayList<Trip> trips) {
        Map<String, Integer> cityCount = new HashMap<>();

        for (Trip t : trips) {
            cityCount.put(t.getCity(), cityCount.getOrDefault(t.getCity(), 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(cityCount.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Top 3 Most Visited Cities:");
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            System.out.println(list.get(i).getKey() + " → " + list.get(i).getValue() + " trips");
        }
    }
}