import java.util.Arrays;

public class BubbleSortStudentMarks {
    public static int[] sortMarks(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return marks;
    }

    public static void main(String[] args) {
        int[] marks = {78, 56, 89, 45, 92, 67};
        System.out.println(Arrays.toString(sortMarks(marks)));
    }
}
