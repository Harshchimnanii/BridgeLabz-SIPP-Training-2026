import java.util.Arrays;

public class SortingScenarioDemo {

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        int totalSwaps = 0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    totalSwaps++;
                }
            }
            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(arr));
            if (!swapped) {
                System.out.println("Array is already sorted after pass " + (i + 1) + ".");
                break;
            }
        }
        System.out.println("Total bubble sort swaps: " + totalSwaps);
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println("After pass " + i + ": " + Arrays.toString(arr));
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(arr));
        }
        return arr;
    }

    public static int[] topKAttendance(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        EmployeeAttendance[] records = new EmployeeAttendance[n];
        for (int i = 0; i < n; i++) {
            records[i] = new EmployeeAttendance(employeeIds[i], attendance[i]);
        }
        Arrays.sort(records);
        return Arrays.stream(records).limit(k).mapToInt(r -> r.employeeId).toArray();
    }

    public static int[] findTopKIDs(int[] employeeIds, int[] attendance, int k) {
        return topKAttendance(employeeIds, attendance, k);
    }

    private static class EmployeeAttendance implements Comparable<EmployeeAttendance> {
        int employeeId;
        int attendance;

        EmployeeAttendance(int employeeId, int attendance) {
            this.employeeId = employeeId;
            this.attendance = attendance;
        }

        @Override
        public int compareTo(EmployeeAttendance other) {
            if (attendance != other.attendance) {
                return Integer.compare(other.attendance, attendance);
            }
            return Integer.compare(employeeId, other.employeeId);
        }
    }

    public static void main(String[] args) {
        int[] athletes = {50, 67, 89, 45, 92, 74, 81, 60};
        System.out.println("Bubble sort on sample scores: " + Arrays.toString(bubbleSort(Arrays.copyOf(athletes, athletes.length))));

        int[] insertionSample = {50, 67, 89, 45, 92, 74, 81, 60};
        System.out.println("Insertion sort on sample scores: " + Arrays.toString(insertionSort(Arrays.copyOf(insertionSample, insertionSample.length))));

        int[] selectionSample = {78, 55, 23, 89, 45};
        System.out.println("Selection sort on sample scores: " + Arrays.toString(selectionSort(Arrays.copyOf(selectionSample, selectionSample.length))));

        int[] ids = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int[] top3 = findTopKIDs(ids, attendance, 3);
        System.out.println("Top 3 employees by attendance: " + Arrays.toString(top3));
    }
}
