//created class named SearchInsertPosition
import java.util.Scanner;
public class SearchInsertPosition{

    //Method to find the index where target is found or should be inserted
    public static int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                 return mid;
             }
            else if(nums[mid] > target){
                 end=mid-1;
             }
            else{
                 start = mid + 1;
              }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int N=input.nextInt();
        int[] nums=new int[N];
        for(int i=0;i<nums.length;i++){
            System.out.print("Enter element " + (i + 1) + ": ");
            nums[i] = input.nextInt();
        }
        System.out.print("Enter target value: ");
        int target = input.nextInt();
        int position = searchInsert(nums, target);
        System.out.println("Target position: " + position);
    }
}