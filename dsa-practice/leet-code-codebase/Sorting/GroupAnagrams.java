import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        List<List<String>> result = groupAnagrams(strs);

        for (List<String> group : result) {
            System.out.print("[");
            for (String s : group) {
                System.out.print(s + " ");
            }
            System.out.print("] ");
        }
    }
}
