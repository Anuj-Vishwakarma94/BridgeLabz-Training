//created class named TwoSum
import java.util.Scanner;
public class TwoSum{

    //Method to find indices of two numbers whose sum equals the target
    public static int[] twoSum(int[] nums, int target) {
        int[] sum=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    sum[0]=i;
                    sum[1]=j;
                }
            }
        }
        return sum;
    }
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int N=input.nextInt();
        int[] nums=new int[N];
        for(int i=0;i< nums.length;i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            nums[i]=input.nextInt();
        }
        System.out.print("Enter target sum: ");
        int target=input.nextInt();
        int[] result=twoSum(nums,target);
        System.out.println("Indices: " + result[0] + " " + result[1]);
    }
}