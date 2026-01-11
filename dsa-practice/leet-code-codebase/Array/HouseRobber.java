import java.util.Scanner;

public class HouseRobber {

    public static int rob(int[] nums) {
        int prev2 = 0; // money till i-2
        int prev1 = 0; // money till i-1

        for (int num : nums) {
            int curr = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of houses: ");
        int n = input.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter money in each house:");
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        System.out.println("Maximum money robbed: " + rob(nums));

        input.close();
    }
}
