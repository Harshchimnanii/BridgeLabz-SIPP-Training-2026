import java.util.Arrays;

public class InsertionSortArray {
    public static int[] insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{12, 11, 13, 5, 6}))); 
        System.out.println(Arrays.toString(insertionSort(new int[]{5, 4, 3, 2, 1}))); 
    }
}
