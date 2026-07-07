import java.util.Scanner;

class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] patientBills = {5000, 7000, 3000};

        try {

            System.out.print("Enter Patient Index: ");
            int index = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Number of Items: ");
            int items = Integer.parseInt(sc.nextLine());

            int averageBill = patientBills[index] / items;

            System.out.println("Average Bill = " + averageBill);

            System.out.print("Enter Payment Amount: ");
            int payment = Integer.parseInt(sc.nextLine());

            if (payment < patientBills[index]) {
                throw new InsufficientFundsException("Payment is insufficient.");
            }

            System.out.println("Payment Successful.");

        }
        catch (ArithmeticException e) {
            System.out.println("Error: Number of items cannot be zero.");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index.");
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numeric input.");
        }
        catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}