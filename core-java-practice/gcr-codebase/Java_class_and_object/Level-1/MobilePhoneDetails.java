public class MobilePhoneDetails {
    private String brand;
    private String model;
    private double price;

    public MobilePhoneDetails(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MobilePhoneDetails phone = new MobilePhoneDetails("Samsung", "Galaxy S23", 72000.0);
        phone.displayDetails();
    }
}
