import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += prefixCount.getOrDefault(sum - k, 0);
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solver = new SubarraySumEqualsK();
        System.out.println(solver.subarraySum(new int[]{1, 1, 1}, 2));
    }
}
