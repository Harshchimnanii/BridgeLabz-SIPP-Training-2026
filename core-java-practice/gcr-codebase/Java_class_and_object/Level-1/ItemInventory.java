public class ItemInventory {
    private String itemCode;
    private String itemName;
    private double price;

    public ItemInventory(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Item Details:");
        System.out.println("Code: " + itemCode);
        System.out.println("Name: " + itemName);
        System.out.println("Price: " + price);
    }

    public double totalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        ItemInventory item = new ItemInventory("I101", "Keyboard", 750.0);
        item.displayDetails();
        System.out.println("Total cost for 5 units: " + item.totalCost(5));
    }
}
