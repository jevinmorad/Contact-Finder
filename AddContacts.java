import java.util.HashMap;
import java.util.Scanner;

class AddContacts {
    public void addContacts(String name, String number, int n) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> map = new HashMap<>();

        ReadWrite set = new ReadWrite();
        map = set.read();

        boolean flag = true;
        // Getting information about name and number
        System.out.print("Enter number of contacts you want to add : ");
        for (int i = 0; i < n; i++) {
            //
            String check = map.put(number, name);

            if (check == null) {
                System.out.println("Contact added succesfully.\n");
                flag = false;
            } else {
                System.out.println("Contact already exist.\n");
            }
        }

        if (flag) {
            // Calling write method of ReadWrite class to edit new contacts in file
            set.write(map);
        }

        sc.close();
    }
}
