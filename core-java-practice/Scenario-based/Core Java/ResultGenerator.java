import java.util.Scanner;

public class ResultGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int marks;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter marks of Subject " + i + ": ");
            marks = sc.nextInt();
            total += marks;
        }

        double average = total / 5.0;

        int gradeCode;

        if (average >= 90)
            gradeCode = 1;
        else if (average >= 80)
            gradeCode = 2;
        else if (average >= 70)
            gradeCode = 3;
        else if (average >= 60)
            gradeCode = 4;
        else
            gradeCode = 5;

        System.out.println("\nAverage = " + average);

        switch (gradeCode) {
            case 1:
                System.out.println("Grade : A+");
                break;

            case 2:
                System.out.println("Grade : A");
                break;

            case 3:
                System.out.println("Grade : B");
                break;

            case 4:
                System.out.println("Grade : C");
                break;

            default:
                System.out.println("Grade : Fail");
        }

        sc.close();
    }
}