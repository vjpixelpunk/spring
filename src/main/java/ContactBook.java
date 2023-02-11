import java.io.*;
import java.util.*;

public class ContactBook {

    private Map<String, Contact> contacts;

    public ContactBook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        this.contacts.put(contact.getName(), contact);
    }

    public Contact searchContact(String name) {
        return this.contacts.get(name);
    }

    public void addContactsFromCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] contactDetails = line.split(",");
                Contact contact = new Contact(contactDetails[0], contactDetails[1], contactDetails[2]);
                addContact(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadContactsAsCSV(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Contact contact : this.contacts.values()) {
                bw.write(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmail());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
