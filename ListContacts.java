import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class ListContacts {
    public void listOfContacts() {
        try {
            File contact = new File("contact.csv");
            FileReader fr = new FileReader(contact);
            BufferedReader br = new BufferedReader(fr);
            // Creared a HashMap with phoneNumber as a key and name as value
            HashMap<String, String> contactMap = new HashMap<String, String>();
            String line;
            // reading character untill file ends
            while ((line = br.readLine()) != null) {
                // dividing line into parts and storing it in an array
                String[] part = line.split(",");
                // storing phoneNumber and name in the HashMap
                contactMap.put(part[0], part[1]);
            }
            // created a set to iterate over the HashMap in order to print name and contact
            Set<Map.Entry<String, String>> entrySet = contactMap.entrySet();
            System.out.println(" Name                   Number\n");
            for (Map.Entry<String, String> entry : entrySet) {
                System.out.printf(" %-20s %s%n", entry.getValue(), entry.getKey());
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
