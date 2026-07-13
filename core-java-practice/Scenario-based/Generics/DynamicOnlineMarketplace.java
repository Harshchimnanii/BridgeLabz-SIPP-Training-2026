import java.util.ArrayList;
import java.util.List;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Book";
    }
}

class ClothingCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Gadget";
    }
}

class Product<T extends Category> {
    private final String name;
    private final double price;
    private final T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", price=" + price + ", category=" + category.getCategoryName() + '}';
    }
}

public class DynamicOnlineMarketplace {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        System.out.println("Discounted price for " + product.getName() + ": " + discountedPrice);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 799.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Denim Shirt", 1199.0, new ClothingCategory());
        Product<GadgetCategory> headphone = new Product<>("Wireless Headphones", 2499.0, new GadgetCategory());

        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(headphone);

        System.out.println("Marketplace catalog:");
        for (Product<? extends Category> product : catalog) {
            System.out.println(" - " + product);
        }

        applyDiscount(book, 10);
        applyDiscount(shirt, 15);
        applyDiscount(headphone, 20);
    }
}
