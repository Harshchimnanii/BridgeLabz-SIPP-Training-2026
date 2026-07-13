
public class SearchScenariosDemo {

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static int searchRotated(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findMinInRotated(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] sortedStars = {1, 4, 7, 13, 19, 26, 32, 40, 47, 55};
        System.out.println("Binary search for 19: " + binarySearch(sortedStars, 19));
        System.out.println("Binary search for 20: " + binarySearch(sortedStars, 20));

        int[] rotatedCatalog = {40, 47, 55, 1, 4, 7, 13, 19, 26, 32};
        System.out.println("Search rotated for 19: " + searchRotated(rotatedCatalog, 19));
        System.out.println("Search rotated for 20: " + searchRotated(rotatedCatalog, 20));

        int[] repeated = {1, 1, 3, 3, 3, 5, 7, 7};
        System.out.println("First occurrence of 3: " + findFirstOccurrence(repeated, 3));
        System.out.println("Last occurrence of 3: " + findLastOccurrence(repeated, 3));

        int[] rotated = {13, 19, 26, 32, 40, 47, 55, 1, 4, 7};
        System.out.println("Min element in rotated array: " + findMinInRotated(rotated));
    }
}
