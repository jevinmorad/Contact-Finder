import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. List all contacts");
        System.out.println("2. Add contact");
        System.out.println("3. Edit contact");
        System.out.println("4. Delete contact");
        System.out.println("5. Search name");
        System.out.println("6. Search number");
        System.out.println("7. Sort contact");
        System.out.println("8. Continue");
        System.out.println("0. Exit");
        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        System.out.println();
        switch (choice) {
            case 1:
                GetContacts contacts = new GetContacts();
                contacts.getContacts();
                break;
            case 2:
                AddContacts add = new AddContacts(); 
                add.addContacts();
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}