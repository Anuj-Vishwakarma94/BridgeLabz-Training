//created class named RemoveElements
import java.util.Scanner;
public class RemoveElements{

    //Method to remove all occurrences of a given value and return new length
    public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int N=input.nextInt();
        int[] nums=new int[N];

        for(int i=0;i<nums.length;i++){
            System.out.print("Enter element " + (i + 1) + ": ");
            nums[i]=input.nextInt();
        }
        System.out.print("Enter value to remove: ");
        int val=input.nextInt();

        int length=removeElement(nums, val);

        System.out.println("New length after removing element: " + length);
        System.out.print("Updated array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}