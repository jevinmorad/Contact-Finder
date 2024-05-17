import java.util.HashMap;
import java.util.Scanner;

class AddContacts {
    public void addContacts(String name[], String number[], int n) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> map = new HashMap<>();

        ReadWrite set = new ReadWrite();
        map = set.read();

        boolean[] flag = {false,false};

        for (int i = 0; i < n; i++) {
            String check = map.put(number[i], name[i]);

            if (check != null) {
                System.out.println("\n"+number[i]+" contact has not been entered as it is already exist.");
                flag[1]=true;
            }
            else {
                flag[0] = true;
            }
        }
        if (flag[0]) {
            // Calling write method of ReadWrite class to add new contacts in file
            set.write(map);
            if (flag[1]) {
                System.out.println("\nAll other contacts are added.");
            }
            else {
                System.out.println("\nContact added.");
            }
        }

        sc.close();
    }
}
