import java.util.*;

public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double totalCost() {
        return price * quantity;
    }

    public void displayDetails() {
        System.out.println("Cart Item: " + itemName + " | Price: " + price + " | Quantity: " + quantity + " | Total: " + totalCost());
    }

    public static void main(String[] args) {
        List<CartItem> cart = new ArrayList<>();
        cart.add(new CartItem("Laptop", 45000.0, 1));
        cart.add(new CartItem("Mouse", 750.0, 2));

        System.out.println("Cart contents:");
        for (CartItem item : cart) {
            item.displayDetails();
        }

        double total = cart.stream().mapToDouble(CartItem::totalCost).sum();
        System.out.println("Total cart cost: " + total);
    }
}
