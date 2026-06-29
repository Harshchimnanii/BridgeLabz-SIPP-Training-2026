import java.io.*;
import java.util.*;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.txt", true))) {
            System.out.print("How many expense entries do you want to add? ");
            int count = scanner.hasNextInt() ? scanner.nextInt() : 0;
            scanner.nextLine();

            for (int i = 0; i < count; i++) {
                System.out.print("Enter expense category: ");
                String category = scanner.nextLine().trim();
                System.out.print("Enter amount: ");
                String amount = scanner.nextLine().trim();
                if (!category.isEmpty() && !amount.isEmpty()) {
                    writer.write(category + " - " + amount);
                    writer.newLine();
                }
            }
            System.out.println("Expenses recorded to expenses.txt");
        } catch (IOException e) {
            System.out.println("Unable to write expenses: " + e.getMessage());
        }
    }
}
