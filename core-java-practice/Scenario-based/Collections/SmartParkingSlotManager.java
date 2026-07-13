import java.util.ArrayList;

public class SmartParkingSlotManager {

    private final ArrayList<String> parkedVehicles = new ArrayList<>();

    public boolean enterVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println("Vehicle " + registrationNumber + " is already parked.");
            return false;
        }
        parkedVehicles.add(registrationNumber);
        return true;
    }

    public boolean exitVehicle(String registrationNumber) {
        return parkedVehicles.remove(registrationNumber);
    }

    public boolean isVehicleParked(String registrationNumber) {
        return parkedVehicles.contains(registrationNumber);
    }

    public void displayParkedVehicles() {
        System.out.println("Currently parked vehicles (" + parkedVehicles.size() + " slots):");
        for (String reg : parkedVehicles) {
            System.out.println("- " + reg);
        }
    }

    public static void main(String[] args) {
        SmartParkingSlotManager parking = new SmartParkingSlotManager();

        parking.enterVehicle("MH12AB1234");
        parking.enterVehicle("KA05CD6789");
        parking.enterVehicle("DL1AA0001");
        parking.enterVehicle("KH14XY9012");
        parking.enterVehicle("KA05CD6789");

        parking.displayParkedVehicles();

        System.out.println("\nSearching for DL1AA0001: " + parking.isVehicleParked("DL1AA0001"));
        System.out.println("Searching for TN09BB4321: " + parking.isVehicleParked("TN09BB4321"));

        System.out.println("\nVehicle DL1AA0001 exits.");
        parking.exitVehicle("DL1AA0001");

        parking.displayParkedVehicles();
    }
}
