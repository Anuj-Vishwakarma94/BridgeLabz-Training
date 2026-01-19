import java.util.HashSet;

class HappyNumber {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = nextNumber(n);
        }
        return true;
    }

    private static int nextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n1 = 19;
        int n2 = 2;

        System.out.println(isHappy(n1));
        System.out.println(isHappy(n2));
    }
}
