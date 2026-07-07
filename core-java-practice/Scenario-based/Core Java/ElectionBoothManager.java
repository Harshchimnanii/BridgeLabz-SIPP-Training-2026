import java.util.Scanner;

public class ElectionBoothManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int candidate1 = 0;
        int candidate2 = 0;
        int candidate3 = 0;

        while (true) {

            System.out.print("\nEnter Age (-1 to Exit): ");
            int age = sc.nextInt();

            // Special exit code
            if (age == -1) {
                break;
            }

            // Eligibility Check
            if (age >= 18) {

                System.out.println("\nChoose Candidate");
                System.out.println("1. Candidate A");
                System.out.println("2. Candidate B");
                System.out.println("3. Candidate C");

                System.out.print("Enter Your Vote: ");
                int vote = sc.nextInt();

                switch (vote) {

                    case 1:
                        candidate1++;
                        System.out.println("Vote Recorded for Candidate A");
                        break;

                    case 2:
                        candidate2++;
                        System.out.println("Vote Recorded for Candidate B");
                        break;

                    case 3:
                        candidate3++;
                        System.out.println("Vote Recorded for Candidate C");
                        break;

                    default:
                        System.out.println("Invalid Vote");
                }

            } else {
                System.out.println("Sorry! You are not eligible to vote.");
            }
        }

        System.out.println("\n===== Election Result =====");
        System.out.println("Candidate A : " + candidate1 + " votes");
        System.out.println("Candidate B : " + candidate2 + " votes");
        System.out.println("Candidate C : " + candidate3 + " votes");

        sc.close();
    }
}