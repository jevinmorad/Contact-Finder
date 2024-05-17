import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. List all contacts");
        System.out.println("2. Add contacts");
        System.out.println("3. Delete contact");
        System.out.println("4. Edit contact");
        System.out.println("5. Search contact");
        System.out.println("0. Exit");
        System.out.print("\nEnter your choice: ");
        char choice = sc.next().charAt(0);
        sc.nextLine();
        System.out.println();
        switch (choice) {
            case '1':
                GetContacts contacts = new GetContacts();
                contacts.getContacts();
                break;

            case '2':
                AddContacts add = new AddContacts();
                System.out.print("Enter total number of contacts you want to add: ");
                int n = sc.nextInt();
                sc.nextLine();
                String[] name = new String[n];
                String[] number = new String[n];
                for (int i = 0; i < n; i++) {
                    System.out.println("For contact : " + (i + 1));
                    System.out.print("   Enter contact name : ");
                    name[i] = sc.nextLine();
                    System.out.print("   Enter contact number : ");
                    number[i] = sc.nextLine();    
                }
                add.addContacts(name, number, n);
                break;

            case '3':
                DeleteContacts delete = new DeleteContacts();

                System.out.print("Enter contact name or number to delete contact : ");
                String deleteContact = sc.nextLine();

                delete.deleteContacts(deleteContact);
                break;

            case '4':
                EditContacts edit = new EditContacts();

                System.out.print("Enter what you want to edit\n\t1. Name\n\t2. Number\nEnter your choice : ");
                char editChoice = sc.next().charAt(0);
                sc.nextLine();
                switch (editChoice) {
                    case '1':
                        System.out.print("\nEnter name of the contact you want to change : ");
                        String oldName = sc.nextLine();
                        edit.changeName(oldName);
                        break;
                    case '2':
                        System.out.print("\nEnter contact number you want change : ");
                        String oldNumber = sc.nextLine();
                        edit.changeNumber(oldNumber);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            
            case '5':
                SearchContacts search = new SearchContacts();

                System.out.print("Enter name or number to search : ");
                String searchValue = sc.nextLine();
                search.searchContact(searchValue);
                break;
            
            case '0':
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice.");
        }
        sc.close();
    }
}