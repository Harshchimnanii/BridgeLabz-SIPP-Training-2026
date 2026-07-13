
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int count = 0;
        int product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK solver = new SubarrayProductLessThanK();
        System.out.println(solver.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
