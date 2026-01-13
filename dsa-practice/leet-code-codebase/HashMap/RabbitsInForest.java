import java.util.*;

class RabbitsInForest {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : answers) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int result = 0;

        for (int x : map.keySet()) {
            int count = map.get(x);
            int groupSize = x + 1;
            int groups = (count + groupSize - 1) / groupSize;
            result += groups * groupSize;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answers = new int[n];

        for (int i = 0; i < n; i++) {
            answers[i] = sc.nextInt();
        }

        RabbitsInForest obj = new RabbitsInForest();
        System.out.println(obj.numRabbits(answers));
    }
}
