import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 4SumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> m = new HashMap<>();

        for (int a : A)
            for (int b : B)
                m.put(a + b, m.getOrDefault(a + b, 0) + 1);

        for (int c : C)
            for (int d : D)
                count += m.getOrDefault(-(c + d), 0);

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution obj = new Solution();

        System.out.print("Enter size of arrays: ");
        int n = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        System.out.println("Enter elements of array A:");
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();

        System.out.println("Enter elements of array B:");
        for (int i = 0; i < n; i++) B[i] = sc.nextInt();

        System.out.println("Enter elements of array C:");
        for (int i = 0; i < n; i++) C[i] = sc.nextInt();

        System.out.println("Enter elements of array D:");
        for (int i = 0; i < n; i++) D[i] = sc.nextInt();

        int result = obj.fourSumCount(A, B, C, D);
        System.out.println("Number of tuples: " + result);
    }
}
