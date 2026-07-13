import java.util.Arrays;

public class FraudDetectionPairSum {

    public static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;
        while (left < right) {
            int sum = transactions[left] + transactions[right];
            if (sum == target) {
                return new int[]{transactions[left], transactions[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] transactions = {10000, 15000, 20000, 24999, 30000, 40000};
        int target = 49999;
        System.out.println(Arrays.toString(findPairSum(transactions, target)));
    }
}
