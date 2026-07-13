import java.util.HashMap;

public class FirstUniqueEvenElement {
    public int firstUniqueEven(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }
        for (int num : nums) {
            if (num % 2 == 0 && counts.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueEvenElement solver = new FirstUniqueEvenElement();
        System.out.println(solver.firstUniqueEven(new int[]{1, 2, 3, 2, 4, 4, 6}));
    }
}
