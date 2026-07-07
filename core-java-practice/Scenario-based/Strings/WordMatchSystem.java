import java.util.Arrays;
import java.util.Scanner;

public class WordMatchSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First String: ");
        String str1 = sc.nextLine();

        System.out.print("Enter Second String: ");
        String str2 = sc.nextLine();

        // Convert to uppercase
        System.out.println("\nUppercase Strings:");
        System.out.println(str1.toUpperCase());
        System.out.println(str2.toUpperCase());

        // Length of strings
        System.out.println("\nLength of First String : " + str1.length());
        System.out.println("Length of Second String: " + str2.length());

        // Check anagram
        char[] arr1 = str1.toLowerCase().replace(" ", "").toCharArray();
        char[] arr2 = str2.toLowerCase().replace(" ", "").toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("\nResult: Both strings are Anagrams.");
        } else {
            System.out.println("\nResult: Both strings are NOT Anagrams.");
        }

        sc.close();
    }
}