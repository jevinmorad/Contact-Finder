import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class GetContacts {
    public void getContacts() {
        HashMap<String, String> map = new HashMap<>();

        ReadWrite set = new ReadWrite();
        map = set.read();
        
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        
        System.out.println(" Name                   Number\n");
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.printf(" %-20s %s %n", entry.getValue(), entry.getKey());
        }
    }
}
