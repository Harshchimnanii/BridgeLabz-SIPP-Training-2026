import java.util.List;

public class GenericUtils {

    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void printList(List<?> list) {
        System.out.println("List contents:");
        for (Object item : list) {
            System.out.println(" - " + item);
        }
    }
}
