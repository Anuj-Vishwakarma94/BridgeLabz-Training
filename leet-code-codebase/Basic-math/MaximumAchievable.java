import java.util.Scanner;

public class MaximumAchievable {

    public static int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int t = input.nextInt();
        System.out.println(theMaximumAchievableX(num, t));
    }
}
