import java.util.Scanner;

public class ArrangingCoins {

    // Finds number of complete staircase rows
    public static int arrangeCoins(int n) {
        int row = 0;

        while (n >= row + 1) {
            row++;
            n -= row;
        }

        return row;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of coins: ");
        int n = input.nextInt();

        System.out.println(arrangeCoins(n));

        input.close();
    }
}
