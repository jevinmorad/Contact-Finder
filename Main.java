import java.io.*;
import java.util.*;

class ContactSet{
    public HashMap<String, String> getSet(){
        HashMap<String, String> contactMap = new HashMap<String, String>();
        try {
            File contact = new File("contact.csv");
            FileReader fr = new FileReader(contact);
            BufferedReader br = new BufferedReader(fr);
            // Creared a HashMap with phoneNumber as a key and name as value
            String line;
            // reading character untill file ends
            while ((line = br.readLine()) != null) {
                // dividing line into parts and storing it in an array
                String[] part = line.split(",");
                // storing phoneNumber and name in the HashMap
                contactMap.put(part[0], part[1]);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return contactMap;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. List all contacts");
        System.out.println("2. Add contact");
        System.out.println("3. Edit contact");
        System.out.println("4. Delete contact");
        System.out.println("5. Search name");
        System.out.println("6. Search number");
        System.out.println("7. Sort contact");
        System.out.println("8. Continue");
        System.out.println("0. Exit");
        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        System.out.println();
        switch (choice) {
            case 1:
                GetContacts contacts = new GetContacts();
                contacts.getContacts();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}