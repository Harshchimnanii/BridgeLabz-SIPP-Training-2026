public class PeakElementFinder {

    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakElement(array);
        System.out.println("Peak index: " + peakIndex + ", value: " + array[peakIndex]);
    }
}
