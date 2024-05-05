import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class DeleteContacts {
    public void deleteContacts(){
        Scanner sc = new Scanner(System.in);

        //Reading all contacts
        HashMap<String, String> map = new HashMap<>();
        ReadWrite rw = new ReadWrite();
        map = rw.read();

        // Printing all available contacts
        System.out.println("Available Contacts\n");
        GetContacts gc = new GetContacts();
        gc.getContacts();

        // about delete contact
        System.out.print("\nEnter contact name or number to delete contact : ");
        String deleteContact = sc.nextLine();
        boolean flag = true;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            // Checking whether the key or value of the contact to be deleted is the same as the contact to be deleted
            if (deleteContact.equals(entry.getValue()) || deleteContact.equals(entry.getKey())) {
                iterator.remove();
                flag = false;
                System.out.println("Contact removed successfully");
            }
        }
        if (flag) {
            System.out.println("Contact not found.");
        }

        // writing into file
        rw.write(map);

        sc.close();
    }
}
