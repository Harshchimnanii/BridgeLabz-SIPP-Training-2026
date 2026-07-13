import java.util.Arrays;

public class InsertionSortEmployeeIds {
    public static int[] sortEmployeeIds(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
        return ids;
    }

    public static void main(String[] args) {
        int[] ids = {105, 101, 104, 102, 103};
        System.out.println(Arrays.toString(sortEmployeeIds(ids)));
    }
}
