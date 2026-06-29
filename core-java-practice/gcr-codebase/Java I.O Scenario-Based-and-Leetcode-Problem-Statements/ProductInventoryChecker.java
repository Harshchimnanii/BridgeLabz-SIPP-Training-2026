import java.io.*;

public class ProductInventoryChecker {
    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "inventory.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean foundOutOfStock = false;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split("-");
                if (parts.length != 2) {
                    continue;
                }
                String product = parts[0].trim();
                int quantity;
                try {
                    quantity = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    continue;
                }
                if (quantity == 0) {
                    System.out.println(product + " is out of stock");
                    foundOutOfStock = true;
                }
            }
            if (!foundOutOfStock) {
                System.out.println("No out-of-stock items found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
    }
}
