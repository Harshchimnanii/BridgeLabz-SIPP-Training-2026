public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long length = 0;
        for (int num : nums) {
            if (num == 0) {
                length++;
            } else {
                count += length * (length + 1) / 2;
                length = 0;
            }
        }
        count += length * (length + 1) / 2;
        return count;
    }

    public static void main(String[] args) {
        NumberOfZeroFilledSubarrays solver = new NumberOfZeroFilledSubarrays();
        System.out.println(solver.zeroFilledSubarray(new int[]{0, 0, 0, 2, 0}));
    }
}
