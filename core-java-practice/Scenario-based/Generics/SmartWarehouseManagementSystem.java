import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private final String name;
    private final int quantity;

    protected WarehouseItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + "name='" + name + '\'' + ", quantity=" + quantity + '}';
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name, int quantity) {
        super(name, quantity);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, int quantity) {
        super(name, quantity);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, int quantity) {
        super(name, quantity);
    }
}

class Storage<T extends WarehouseItem> {
    private final List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(T item) {
        return items.remove(item);
    }

    public List<T> getItems() {
        return new ArrayList<>(items);
    }
}

public class SmartWarehouseManagementSystem {

    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("Stored warehouse items:");
        for (WarehouseItem item : items) {
            System.out.println(" - " + item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Smartphone", 50));
        electronicsStorage.addItem(new Electronics("Laptop", 30));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice", 200));
        groceryStorage.addItem(new Groceries("Olive Oil", 80));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Office Chair", 20));
        furnitureStorage.addItem(new Furniture("Dining Table", 10));

        displayAllItems(electronicsStorage.getItems());
        displayAllItems(groceryStorage.getItems());
        displayAllItems(furnitureStorage.getItems());
    }
}
