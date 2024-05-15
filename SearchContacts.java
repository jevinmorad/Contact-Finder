import java.util.*;

class SearchContacts {
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, String> foundValue = new HashMap<>();
    // ArrayList is created beacuse we can't get perticular value with the use of set
    ArrayList<String> number = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();

    Iterator<Map.Entry<String, String>> iterator;

    ReadWrite rw = new ReadWrite();

    public SearchContacts(){
        map = rw.read();
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            number.add(entry.getKey());
            name.add(entry.getValue());
        }
    }    

    public void searchContact(String searchValue) {
        int i=0;
        while (i<name.size()) {
            if (name.get(i).contains(searchValue) || number.get(i).contains(searchValue) ) {
                foundValue.put(number.get(i), name.get(i));
            }
            i++;
        }
        printFoundContacts(foundValue);
    }

    public void printFoundContacts(HashMap<String, String> foundMap){
        if (foundMap.isEmpty()) {
            System.out.println("\nNo contact found..");
            System.exit(0);
        }
        System.out.println("name size : "+name.size()+"\nNumber size : "+number.size());
        iterator = foundMap.entrySet().iterator();

        System.out.println(" Name                   Number\n");
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.printf(" %-20s %s%n", entry.getValue(), entry.getKey());
        }
    }
}
