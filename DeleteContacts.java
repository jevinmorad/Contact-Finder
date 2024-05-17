import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class DeleteContacts {
    HashMap<String, String> map = new HashMap<>();
    HashSet<String> nonUniqueValues = new HashSet<>();
    ReadWrite rw = new ReadWrite();

    public DeleteContacts(){
        map = rw.read();

        HashSet<String> checkUniqueValues = new HashSet<>();
        for (String value : map.values()) {
            boolean check = checkUniqueValues.add(value);
            if (!check) {
                nonUniqueValues.add(value);
            }
        }
    }

    public void deleteContacts(String deleteContact) {
        Scanner sc = new Scanner(System.in);

        // Reading all contacts
        HashMap<String, String> map = new HashMap<>();
        map = rw.read();
        // for same name
        boolean flag = false;
        if (nonUniqueValues.contains(deleteContact)) {
            System.out.println("\nSame name for different number found...");
            System.out.print("\nEnter contact number : ");
            String number = sc.next();
            if (map.containsKey(number)) {
                map.remove(number);
                flag = true;
            } else {
                System.out.println("\nNumber not found...");
            }
        }
        // for not same name
        // We need EntrySet because if the user enters a contact name, we cannot remove it from the map using only the value.
        else {
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                if (deleteContact.equals(entry.getValue()) || deleteContact.equals(entry.getKey())) {
                    iterator.remove();
                    flag=true;
                }
            }
        }
        if (flag) {
            // writing into file
            rw.write(map);
            System.out.println("\nContact deleted...");
        }
        else {
            System.out.println("\nContact not found...");
        }
        sc.close();
    }
}
