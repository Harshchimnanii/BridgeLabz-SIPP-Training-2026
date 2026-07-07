import java.util.Scanner;

public class ParkingLotSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int capacity = 10;
        int occupied = 0;

        while (true) {

            if (occupied == capacity) {
                System.out.println("\nParking Lot Full!");
                break;
            }

            System.out.println("\n====== Parking Menu ======");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    if (occupied < capacity) {
                        occupied++;
                        System.out.println("Vehicle Parked Successfully.");
                    } else {
                        System.out.println("Parking Full.");
                    }
                    break;

                case 2:

                    if (occupied > 0) {
                        occupied--;
                        System.out.println("Vehicle Exited.");
                    } else {
                        System.out.println("Parking Lot Empty.");
                    }
                    break;

                case 3:

                    System.out.println("Occupied Spaces : " + occupied);
                    System.out.println("Available Spaces: " + (capacity - occupied));
                    break;

                case 4:

                    System.out.println("System Closed.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }

        sc.close();
    }
}