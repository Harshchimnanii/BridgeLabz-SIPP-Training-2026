import java.io.*;
import java.util.*;

public class DailyExpenseLogger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            FileWriter fw = new FileWriter("expenses.txt", true); // append mode

            System.out.print("Enter Expense Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Amount: ");
            int amount = sc.nextInt();

            fw.write(category + " - " + amount + "\n");

            fw.close();

            System.out.println("Expense saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving expense.");
        }

        sc.close();
    }
}