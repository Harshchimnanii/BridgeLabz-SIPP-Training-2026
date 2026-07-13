public class BubbleSortSwapCount {
    public static int countSwaps(int[] nums) {
        int swaps = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(countSwaps(new int[]{4, 3, 2, 1}));
        System.out.println(countSwaps(new int[]{1, 2, 3}));
    }
}
