import java.util.HashMap;
import java.util.Scanner;

class AddContacts {
    public void addContacts(){
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> map = new HashMap<>();

        ReadWrite set = new ReadWrite();
        map = set.read();

        boolean flag = true;
        // Getting information about name and number
        System.out.print("Enter number of contacts you want to add : ");
        int n= sc.nextInt();
        System.out.println();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("For contact : "+(i+1));
            System.out.print("  Enter contact name : ");
            String name = sc.nextLine();
            System.out.print("  Enter contact number : ");
            String number = sc.next();
            
            String check = map.put(number, name);

            if (check == null) {
                System.out.println("Contact added succesfully.\n");
                flag = false;
            }
            else {
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
