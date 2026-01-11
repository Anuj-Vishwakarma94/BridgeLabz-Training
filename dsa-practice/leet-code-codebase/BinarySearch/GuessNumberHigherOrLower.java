import java.util.Scanner;

public class GuessNumberHigherOrLower {

    public static int guessNumber(int n, int pick) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == pick) {
                return mid;
            } else if (mid > pick) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter pick: ");
        int pick = sc.nextInt();

        System.out.println("Picked number is: " + guessNumber(n, pick));

        sc.close();
    }
}
