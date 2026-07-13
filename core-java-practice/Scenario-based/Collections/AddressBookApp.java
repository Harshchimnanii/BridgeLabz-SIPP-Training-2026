import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

public class AddressBookApp {

    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final HashMap<String, Contact> lookupByName = new HashMap<>();
    private final HashSet<String> phoneNumbers = new HashSet<>();

    public boolean addContact(String name, String phone, String email) {
        if (lookupByName.containsKey(name)) {
            System.out.println("Contact with name '" + name + "' already exists.");
            return false;
        }
        if (phoneNumbers.contains(phone)) {
            System.out.println("Phone number '" + phone + "' is already used by another contact.");
            return false;
        }
        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        lookupByName.put(name, contact);
        phoneNumbers.add(phone);
        return true;
    }

    public Contact searchContactByName(String name) {
        return lookupByName.get(name);
    }

    public boolean deleteContactByName(String name) {
        Contact contact = lookupByName.remove(name);
        if (contact == null) {
            return false;
        }
        contacts.remove(contact);
        phoneNumbers.remove(contact.phone);
        return true;
    }

    public List<Contact> getContactsSortedByName() {
        ArrayList<Contact> sorted = new ArrayList<>(contacts);
        Collections.sort(sorted, (a, b) -> a.name.compareToIgnoreCase(b.name));
        return sorted;
    }

    public static void main(String[] args) {
        AddressBookApp addressBook = new AddressBookApp();

        addressBook.addContact("Rohan", "9876543210", "rohan@example.com");
        addressBook.addContact("Aisha", "9988776655", "aisha@example.com");
        addressBook.addContact("Nikhil", "9123456780", "nikhil@example.com");
        addressBook.addContact("Aisha", "9112233445", "aisha2@example.com");

        System.out.println("\nSearch result for 'Rohan':");
        Contact result = addressBook.searchContactByName("Rohan");
        if (result != null) {
            System.out.println(result.name + " | " + result.phone + " | " + result.email);
        }

        System.out.println("\nSorted address book:");
        for (Contact contact : addressBook.getContactsSortedByName()) {
            System.out.println(contact.name + " | " + contact.phone + " | " + contact.email);
        }

        System.out.println("\nDeleting Nikhil...");
        addressBook.deleteContactByName("Nikhil");

        System.out.println("\nUpdated address book:");
        for (Contact contact : addressBook.getContactsSortedByName()) {
            System.out.println(contact.name + " | " + contact.phone + " | " + contact.email);
        }
    }
}
