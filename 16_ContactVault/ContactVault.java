import java.io.*;
import java.util.*;

public class ContactVault {

    static final String FILE_NAME = "contacts.txt";

    static class Contact {
        String name;
        String phone;
        String email;

        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        @Override
        public String toString() {
            return name + " | " + phone + " | " + email;
        }

        String toFileFormat() {
            return name + "|" + phone + "|" + email;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contact> contacts = loadContacts();

        System.out.println("======================================");
        System.out.println("         Welcome to ContactVault      ");
        System.out.println("======================================");

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View All Contacts");
            System.out.println("2. Add Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    displayContacts(contacts);
                    break;
                case "2":
                    addContact(sc, contacts);
                    break;
                case "3":
                    searchContact(sc, contacts);
                    break;
                case "4":
                    updateContact(sc, contacts);
                    break;
                case "5":
                    deleteContact(sc, contacts);
                    break;
                case "6":
                    saveContacts(contacts);
                    System.out.println("Contacts saved. Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }

    static List<Contact> loadContacts() {
        List<Contact> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    list.add(new Contact(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }

        return list;
    }

    static void saveContacts(List<Contact> contacts) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Contact c : contacts) {
                pw.println(c.toFileFormat());
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    static void displayContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n--- Contact List ---");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    static void addContact(Scanner sc, List<Contact> contacts) {
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine().trim();

        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

        if (!phone.matches("\\d{10}")) {
            System.out.println("Invalid phone number. Must be 10 digits.");
            return;
        }

        if (!email.matches("^\\S+@\\S+\\.\\S+$")) {
            System.out.println("Invalid email format.");
            return;
        }

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully.");
    }

    static void searchContact(Scanner sc, List<Contact> contacts) {
        System.out.print("Enter name or phone to search: ");
        String query = sc.nextLine().trim().toLowerCase();
        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.toLowerCase().contains(query) || c.phone.contains(query)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contact found.");
        }
    }

    static void updateContact(Scanner sc, List<Contact> contacts) {
        displayContacts(contacts);
        System.out.print("Enter contact number to update: ");
        int idx;

        try {
            idx = Integer.parseInt(sc.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            return;
        }

        if (idx < 0 || idx >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact c = contacts.get(idx);
        System.out.println("Editing contact: " + c);

        System.out.print("Enter new name (or press Enter to keep \"" + c.name + "\"): ");
        String newName = sc.nextLine();
        if (!newName.trim().isEmpty()) c.name = newName;

        System.out.print("Enter new phone (or press Enter to keep \"" + c.phone + "\"): ");
        String newPhone = sc.nextLine();
        if (!newPhone.trim().isEmpty()) {
            if (!newPhone.matches("\\d{10}")) {
                System.out.println("Invalid phone number.");
                return;
            }
            c.phone = newPhone;
        }

        System.out.print("Enter new email (or press Enter to keep \"" + c.email + "\"): ");
        String newEmail = sc.nextLine();
        if (!newEmail.trim().isEmpty()) {
            if (!newEmail.matches("^\\S+@\\S+\\.\\S+$")) {
                System.out.println("Invalid email.");
                return;
            }
            c.email = newEmail;
        }

        System.out.println("Contact updated successfully.");
    }

    static void deleteContact(Scanner sc, List<Contact> contacts) {
        displayContacts(contacts);
        System.out.print("Enter contact number to delete: ");
        int idx;

        try {
            idx = Integer.parseInt(sc.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            return;
        }

        if (idx < 0 || idx >= contacts.size()) {
            System.out.println("Invalid number.");
            return;
        }

        Contact removed = contacts.remove(idx);
        System.out.println("Deleted: " + removed.name);
    }
}
