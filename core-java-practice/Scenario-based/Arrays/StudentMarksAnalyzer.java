import java.util.Scanner;

public class StudentMarksAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        int countAbove75 = 0;
        int sum = 0;

        // Input marks
        System.out.println("Enter student marks:");
        for (int i = 0; i < n; i++) {

            marks[i] = sc.nextInt();

            sum += marks[i];

            if (marks[i] > highest)
                highest = marks[i];

            if (marks[i] < lowest)
                lowest = marks[i];

            if (marks[i] > 75)
                countAbove75++;
        }

        double average = (double) sum / n;

        System.out.println("\nHighest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);
        System.out.println("Students scoring above 75 : " + countAbove75);
        System.out.printf("Average Marks : %.2f\n", average);

        System.out.println("\nMarks greater than average:");

        for (int mark : marks) {
            if (mark > average)
                System.out.print(mark + " ");
        }

        sc.close();
    }
}