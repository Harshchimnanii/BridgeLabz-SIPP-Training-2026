public class NumberOfSmoothDescentPeriods {
    public long getDescentPeriods(int[] prices) {
        long count = 0;
        int length = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                length++;
            } else {
                count += (long) length * (length + 1) / 2;
                length = 1;
            }
        }
        count += (long) length * (length + 1) / 2;
        return count;
    }

    public static void main(String[] args) {
        NumberOfSmoothDescentPeriods solver = new NumberOfSmoothDescentPeriods();
        System.out.println(solver.getDescentPeriods(new int[]{3, 2, 1, 4}));
    }
}
