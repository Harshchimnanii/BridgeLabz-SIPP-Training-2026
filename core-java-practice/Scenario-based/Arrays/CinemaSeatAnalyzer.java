import java.util.Scanner;

public class CinemaSeatAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total seats: ");
        int n = sc.nextInt();

        int[] seats = new int[n];

        System.out.println("Enter seat status (0 = Empty, 1 = Booked):");

        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }

        int booked = 0;
        int available = 0;

        int maxLength = 0;
        int currentLength = 0;

        int start = -1;
        int end = -1;
        int tempStart = 0;

        for (int i = 0; i < n; i++) {

            if (seats[i] == 0) {

                available++;
                currentLength++;

                if (currentLength == 1)
                    tempStart = i;

                if (currentLength > maxLength) {

                    maxLength = currentLength;
                    start = tempStart;
                    end = i;
                }

            } else {

                booked++;
                currentLength = 0;
            }
        }

        System.out.println("\nBooked Seats : " + booked);
        System.out.println("Available Seats : " + available);

        System.out.println("\nLongest Available Block:");
        System.out.println("Starting Position : " + (start + 1));
        System.out.println("Ending Position   : " + (end + 1));
        System.out.println("Block Length      : " + maxLength);

        if (maxLength >= 5)
            System.out.println("\nGroup of 5 can sit together.");
        else
            System.out.println("\nGroup of 5 cannot sit together.");

        sc.close();
    }
}