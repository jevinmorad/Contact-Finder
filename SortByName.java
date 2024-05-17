import java.util.*;

class SortByName {
    public LinkedHashMap<String, String> sort(HashMap<String, String> map){
        // Convert HashMap to List of Map.Entry
        List<Map.Entry<String, String>> list = new LinkedList<>(map.entrySet());

        // Sort the list using a lambda expression
        list.sort(Map.Entry.comparingByValue());

        // Create a LinkedHashMap to preserve the order of elements
        LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
