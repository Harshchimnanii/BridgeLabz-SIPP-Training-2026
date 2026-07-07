public class DeliveryChargeSystem {

    // Distance only
    public static double calculateCharge(int distance) {

        return distance * 5;
    }

    // Distance + Weight
    public static double calculateCharge(int distance, int weight) {

        return (distance * 5) + (weight * 10);
    }

    // Distance + Weight + Express Delivery
    public static double calculateCharge(int distance, int weight, boolean expressDelivery) {

        double charge = (distance * 5) + (weight * 10);

        if (expressDelivery)
            charge += 100;

        return charge;
    }

    public static void main(String[] args) {

        System.out.println("Charge 1 = ₹" + calculateCharge(15));

        System.out.println("Charge 2 = ₹" + calculateCharge(15, 4));

        System.out.println("Charge 3 = ₹" + calculateCharge(15, 4, true));
    }
}