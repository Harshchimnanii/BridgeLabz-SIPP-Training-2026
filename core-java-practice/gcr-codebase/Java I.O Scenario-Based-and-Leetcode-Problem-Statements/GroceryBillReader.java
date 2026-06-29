import java.io.*;

public class GroceryBillReader {
    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "bill.txt";
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }
            System.out.println("Total lines: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
