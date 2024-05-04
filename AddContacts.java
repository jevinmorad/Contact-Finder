import java.util.HashMap;
import java.util.Scanner;

class AddContacts {
    public void addContacts(){
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> map = new HashMap<>();

        ReadWrite set = new ReadWrite();
        map = set.read();

        int count=0;
        // Getting information about name and number
        System.out.print("Enter number of contacts you want to add : ");
        int n= sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("For contact : "+i);
            System.out.print("  Enter contact name : ");
            String name = sc.next();
            System.out.print("  Enter contact number : ");
            String number = sc.next();
            
            String check = map.put(number, name);

            if (check == null) {
                System.out.println("Contact added succesfully.\n");
                count++;
            }
            else {
                System.out.println("Contact already exist.\n");
            }
        }
        if (count>0) {
            set.write(map);
        }
        
        sc.close();
    }   
}
