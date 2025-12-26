//created class named RemoveDuplicates
import java.util.Scanner;
public class RemoveDuplicates{

    //Method to remove duplicates from sorted array and return new length
    public static int removeDuplicates(int[] nums) {
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int N = input.nextInt();

        int[] nums = new int[N];

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            nums[i] = input.nextInt();
        }

        int length = removeDuplicates(nums);

        System.out.println("New length after removing duplicates: " + length);
        System.out.print("Updated array: ");

        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}