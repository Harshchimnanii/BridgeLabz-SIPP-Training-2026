import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString solver = new FirstUniqueCharacterInAString();
        System.out.println(solver.firstUniqChar("leetcode"));
    }
}
