package com.songvault;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" SongVault – Music Library ");
        System.out.println("=================================");

        System.out.print("Enter songs folder path: ");
        String folderPath = sc.nextLine();

        File folder = new File(folderPath);
        List<Song> songs = new ArrayList<>();
        Map<String, List<Song>> genreMap = new HashMap<>();
        Set<String> uniqueArtists = new HashSet<>();

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No song files found.");
            return;
        }

        Pattern titleP = Pattern.compile("Title:\\s*(.*)");
        Pattern artistP = Pattern.compile("Artist:\\s*(.*)");
        Pattern durationP = Pattern.compile("Duration:\\s*(.*)");
        Pattern genreP = Pattern.compile("Genre:\\s*(.*)");

        for (File file : files) {
            try {
                Song song = parseSong(file, titleP, artistP, durationP, genreP);
                songs.add(song);

                genreMap.putIfAbsent(song.getGenre(), new ArrayList<>());
                genreMap.get(song.getGenre()).add(song);

                uniqueArtists.add(song.getArtist());

            } catch (Exception e) {
                System.out.println("Skipped invalid file: " + file.getName());
            }
        }

        System.out.println("\n===== All Songs =====");
        songs.forEach(System.out::println);

        System.out.println("\n===== Unique Artists =====");
        uniqueArtists.forEach(System.out::println);

        System.out.println("\n===== Songs Grouped by Genre =====");
        genreMap.forEach((genre, list) -> {
            System.out.println("\n" + genre + ":");
            list.forEach(System.out::println);
        });

        System.out.println("\n===== Sorted Songs by Title =====");
        songs.stream()
                .sorted(Comparator.comparing(Song::getTitle))
                .forEach(System.out::println);

        sc.close();
    }

    static Song parseSong(File file,
                          Pattern titleP,
                          Pattern artistP,
                          Pattern durationP,
                          Pattern genreP) throws Exception {

        String title = null, artist = null, duration = null, genre = null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                Matcher m;

                m = titleP.matcher(line);
                if (m.matches()) title = m.group(1);

                m = artistP.matcher(line);
                if (m.matches()) artist = m.group(1);

                m = durationP.matcher(line);
                if (m.matches()) duration = m.group(1);

                m = genreP.matcher(line);
                if (m.matches()) genre = m.group(1);
            }
        }

        if (title == null || artist == null || duration == null || genre == null) {
            throw new RuntimeException("Missing fields");
        }

        return new Song(title, artist, duration, genre);
    }
}