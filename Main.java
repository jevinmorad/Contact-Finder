import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. List all contacts");
        System.out.println("2. Add contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Edit contact");
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
                int n = sc.nextInt();
                sc.nextLine();
                System.out.println();

                for (int i = 0; i < n; i++) {
                    System.out.println("For contact : " + (i + 1));
                    System.out.print("  Enter contact name : ");
                    String name = sc.nextLine();
                    System.out.print("  Enter contact number : ");
                    String number = sc.next();

                    add.addContacts(name, number, n);
                }
                break;
            case 3:
                DeleteContacts delete = new DeleteContacts();

                System.out.print("\nEnter contact name or number to delete contact : ");
                String deleteContact = sc.nextLine();

                delete.deleteContacts(deleteContact);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}