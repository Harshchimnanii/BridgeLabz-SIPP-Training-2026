import java.util.Scanner;

public class UsernameValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        // Check for spaces
        if (username.contains(" ")) {
            System.out.println("Username contains spaces.");
        } else {
            System.out.println("Username does not contain spaces.");
        }

        // Count characters
        System.out.println("Total Characters: " + username.length());

        // Convert to uppercase
        System.out.println("Uppercase Username: " + username.toUpperCase());

        // Check palindrome
        String reverse = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            reverse += username.charAt(i);
        }

        if (username.equalsIgnoreCase(reverse)) {
            System.out.println("Username is a Palindrome.");
        } else {
            System.out.println("Username is NOT a Palindrome.");
        }

        sc.close();
    }
}