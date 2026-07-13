import java.util.HashMap;
import java.util.Map;

public class ApiRateLimiterWindow {

    public static int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int end = 0; end < keyIds.length; end++) {
            freq.merge(keyIds[end], 1, Integer::sum);
            while (freq.size() > n) {
                int leftKey = keyIds[start];
                freq.put(leftKey, freq.get(leftKey) - 1);
                if (freq.get(leftKey) == 0) {
                    freq.remove(leftKey);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] keyIds = {1, 2, 1, 3, 4, 2, 3};
        int n = 2;
        System.out.println(longestSubarrayWithAtMostNDistinct(keyIds, n));
    }
}
