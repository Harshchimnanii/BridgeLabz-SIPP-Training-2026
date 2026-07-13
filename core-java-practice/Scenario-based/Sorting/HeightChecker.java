public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        java.util.Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HeightChecker solution = new HeightChecker();
        System.out.println(solution.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
}
