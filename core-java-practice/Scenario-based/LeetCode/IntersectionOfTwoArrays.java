import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        List<Integer> list = new ArrayList<>(result);
        int[] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays solver = new IntersectionOfTwoArrays();
        int[] result = solver.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
