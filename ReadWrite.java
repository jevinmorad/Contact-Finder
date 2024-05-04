import java.io.*;
import java.util.*;

class ReadWrite {
    HashMap<String, String> readMap = new HashMap<>();
    
    // Reading contacts
    public HashMap<String, String> read() {
        // Created a HashMap with phoneNumber as a key and name as a value

        FileReader fr = null;
        try {
            fr = new FileReader(new File("contact.csv"));
            BufferedReader br = new BufferedReader(fr);

            // reading character untill file ends
            String line;
            while ((line = br.readLine()) != null) {
                // dividing line into parts and storing it in an array
                String[] part = line.split(",");
                readMap.put(part[0], part[1]);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        return readMap;
    }

    // Writing contacts
    public void write(HashMap<String, String> map) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("contact.csv");
            BufferedWriter bw = new BufferedWriter(fw);

            Set<Map.Entry<String, String>> entrySet = map.entrySet();

            for (Map.Entry<String, String> entry : entrySet) {
                String line = entry.getKey()+","+entry.getValue();
                // System.out.println(line);
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}