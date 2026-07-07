import java.util.Scanner;

public class ElectricityBillCalculator {

    // Method to accept units
    public static int acceptUnits() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        return units;
    }

    // Method to calculate bill
    public static double calculateBill(int units) {

        double bill;

        if (units <= 100)
            bill = units * 5;
        else if (units <= 300)
            bill = units * 7;
        else
            bill = units * 10;

        return bill;
    }

    // Method to display bill
    public static void displayBill(int units, double bill) {

        System.out.println("\n------ Electricity Bill ------");
        System.out.println("Units Consumed : " + units);
        System.out.println("Total Bill     : ₹" + bill);
    }

    public static void main(String[] args) {

        int units = acceptUnits();

        double bill = calculateBill(units);

        displayBill(units, bill);
    }
}