public class CpuSpikeFixedWindow {

    public static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= cpuLoad[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] cpuLoad = {10, 20, 30, 40, 50, 60, 70};
        int k = 5;
        System.out.println(maxSubarrayOfSizeK(cpuLoad, k));
    }
}
