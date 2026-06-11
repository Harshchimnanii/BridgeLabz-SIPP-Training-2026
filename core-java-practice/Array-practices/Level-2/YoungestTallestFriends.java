import java.util.Scanner;

public class YoungestTallestFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print(names[i] + " age: ");
            ages[i] = sc.nextInt();
            System.out.print(names[i] + " height (m): ");
            heights[i] = sc.nextDouble();
        }

        int youngestIdx = 0;
        for (int i = 1; i < 3; i++) if (ages[i] < ages[youngestIdx]) youngestIdx = i;

        int tallestIdx = 0;
        for (int i = 1; i < 3; i++) if (heights[i] > heights[tallestIdx]) tallestIdx = i;

        System.out.println("Youngest: " + names[youngestIdx] + " (" + ages[youngestIdx] + " years)");
        System.out.println("Tallest: " + names[tallestIdx] + " (" + heights[tallestIdx] + " m)");
        sc.close();
    }
}
