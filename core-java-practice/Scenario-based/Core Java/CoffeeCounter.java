import java.util.Scanner;

public class CoffeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String coffeeType;
        int quantity;
        double price = 0;
        double gstRate = 0.05;   // 5% GST

        while (true) {

            System.out.print("\nEnter Coffee Type (Espresso/Latte/Cappuccino) or 'exit' to stop: ");
            coffeeType = sc.next();

            if (coffeeType.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter Quantity: ");
            quantity = sc.nextInt();

            switch (coffeeType.toLowerCase()) {

                case "espresso":
                    price = 120;
                    break;

                case "latte":
                    price = 150;
                    break;

                case "cappuccino":
                    price = 180;
                    break;

                default:
                    System.out.println("Invalid Coffee Type!");
                    continue;   // Skip current iteration
            }

            double total = price * quantity;
            double gst = total * gstRate;
            double finalBill = total + gst;

            System.out.println("\n------- BILL -------");
            System.out.println("Coffee      : " + coffeeType);
            System.out.println("Quantity    : " + quantity);
            System.out.println("Subtotal    : ₹" + total);
            System.out.println("GST (5%)    : ₹" + gst);
            System.out.println("Final Bill  : ₹" + finalBill);
        }

        System.out.println("\nCafe Closed.");
        sc.close();
    }
}