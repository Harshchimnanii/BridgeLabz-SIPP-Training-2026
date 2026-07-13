import java.util.Arrays;

public class SelectionSortExamScores {
    public static int[] sortExamScores(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
        return scores;
    }

    public static void main(String[] args) {
        int[] scores = {88, 72, 95, 65, 80};
        System.out.println(Arrays.toString(sortExamScores(scores)));
    }
}
