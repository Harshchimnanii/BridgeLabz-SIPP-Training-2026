import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter height in cm: ");
        double cm = sc.nextDouble();

        double inches = cm / 2.54;
        double feet = inches / 12;

        System.out.println("Your Height in cm is " + cm +
                " while in feet is " + feet +
                " and inches is " + inches);
    }
}
