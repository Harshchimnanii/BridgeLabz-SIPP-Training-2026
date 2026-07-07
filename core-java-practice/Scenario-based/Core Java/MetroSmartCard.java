import java.util.Scanner;

public class MetroSmartCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 500; // Initial Smart Card Balance
        char choice;

        do {

            System.out.println("\nCurrent Balance: ₹" + balance);

            System.out.print("Enter distance travelled (in km): ");
            int distance = sc.nextInt();

            // Fare using ternary operator
            int fare = (distance <= 5) ? 20 :
                    (distance <= 10) ? 35 :
                    (distance <= 20) ? 50 : 70;

            System.out.println("Fare = ₹" + fare);

            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare Deducted Successfully.");
                System.out.println("Remaining Balance: ₹" + balance);
            } else {
                System.out.println("Insufficient Balance.");
                break;
            }

            if (balance == 0) {
                System.out.println("Balance Exhausted.");
                break;
            }

            System.out.print("Do you want another ride? (Y/N): ");
            choice = sc.next().charAt(0);

        } while (choice == 'Y' || choice == 'y');

        System.out.println("Thank you for using Delhi Metro!");

        sc.close();
    }
}