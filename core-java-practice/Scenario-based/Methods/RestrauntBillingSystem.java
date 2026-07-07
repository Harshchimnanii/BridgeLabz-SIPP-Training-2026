import java.util.Scanner;

public class RestaurantBillingSystem {

    // Calculate food cost
    public static double calculateFoodCost(double price, int quantity) {
        return price * quantity;
    }

    // Calculate GST (5%)
    public static double calculateGST(double amount) {
        return amount * 0.05;
    }

    // Calculate Discount (10% if bill > 1000)
    public static double calculateDiscount(double amount) {

        if (amount > 1000)
            return amount * 0.10;

        return 0;
    }

    // Generate Final Bill
    public static double generateFinalBill(double amount, double gst, double discount) {
        return amount + gst - discount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Food Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        double foodCost = calculateFoodCost(price, quantity);
        double gst = calculateGST(foodCost);
        double discount = calculateDiscount(foodCost);
        double finalBill = generateFinalBill(foodCost, gst, discount);

        System.out.println("\n------ Restaurant Bill ------");
        System.out.println("Food Cost   : ₹" + foodCost);
        System.out.println("GST         : ₹" + gst);
        System.out.println("Discount    : ₹" + discount);
        System.out.println("Final Bill  : ₹" + finalBill);

        sc.close();
    }
}