package com.gamebox;

import java.util.Scanner;

public class GameBox {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== GameBox Store ===\n");

        Game pacman = new ArcadeGame("Pacman - classic", 0.0, 4.6);
        Game subway = new ArcadeGame("Subway Surfers", 149.0, 4.5);
        Game clash = new StrategyGame("Clash of Clans", 0.0, 4.3);
        Game mlbb = new StrategyGame("Mobile Legends", 499.0, 4.7);
        Game pubg = new StrategyGame("Pubg", 699.0, 4.9);
        Game[] storeGames = { pacman, subway, clash, mlbb, pubg };

        System.out.print("Enter player name: ");
        String name = sc.nextLine();
        User player = new User(name);

        System.out.print("\nSummer Sale! Enter discount % on PAID games: ");
        int discount = sc.nextInt();

        System.out.println("\n--- Applying Discount on Paid Games ---");

        for (int i = 0; i < storeGames.length; i++) {
            Game g = storeGames[i];
            if (g.getPrice() > 0) {
                System.out.print((i + 1) + ". ");
                g.applyDiscount(discount);
            }
        }


        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Store Games");
            System.out.println("2. Download Game");
            System.out.println("3. Purchase Game");
            System.out.println("4. Show My Library");
            System.out.println("5. Play Demo (Polymorphism)");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.println("\n--- STORE GAMES ---");

                for (int i = 0; i < storeGames.length; i++) {
                    Game g = storeGames[i];

                    String type = (g.getPrice() == 0) ? "[FREE]" : "[PAID]";
                    System.out.println((i + 1) + ". " + type + " " + g);
                }
                break;
                
            case 2:
                System.out.print("Enter game number to download: ");
                int d = sc.nextInt() - 1;

                if (d >= 0 && d < storeGames.length) {
                    Game selected = storeGames[d];

                    // Free game → download + add to library
                    if (selected.getPrice() == 0) {
                        selected.download();

                        if (!player.hasGame(selected)) {
                            player.purchaseGame(selected); // adds to library
                        }
                    }
                    // Paid & already purchased
                    else if (player.hasGame(selected)) {
                        selected.download();
                    }
                    // Paid but not purchased
                    else {
                        System.out.println("You must purchase this game before downloading!");
                    }

                } else {
                    System.out.println("Invalid game choice");
                }
                break;

                case 3:
                    System.out.print("Enter game number to purchase: ");
                    int p = sc.nextInt() - 1;

                    if (p >= 0 && p < storeGames.length) {
                        player.purchaseGame(storeGames[p]);
                    } else {
                        System.out.println("Invalid game choice");
                    }
                    break;

                case 4:
                    player.showLibrary();
                    break;

                case 5:
                    player.playDemos();
                    break;

                case 6:
                    System.out.println("\n=== Thank you for using GameBox ===");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
