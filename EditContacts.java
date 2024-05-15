import java.util.*;

class EditContacts {
    HashMap<String, String> map = new HashMap<>();
    HashSet<String> nonUniqueValues = new HashSet<>();
    ReadWrite rw = new ReadWrite();
    
    public EditContacts(){
        map = rw.read();

        HashSet<String> checkUniqueValues = new HashSet<>();
        for (String value : map.values()) {
            boolean check = checkUniqueValues.add(value);
            if (!check) {
                nonUniqueValues.add(value);
            }
        }
    }

    // to change name
    public void changeName(String oldName) {
        Scanner sc = new Scanner(System.in);
        
        if (!map.containsValue(oldName)) {
            System.out.println("Contact not found");
            System.exit(1);
        }

        boolean flag = false;
        String number;
        String newName;
        // checking for duplicate value.
        if (nonUniqueValues.contains(oldName)) {
            System.out.println("\nSame name for different number found.");

            System.out.print("\nEnter contact number : ");
            number = sc.nextLine();
            System.out.print("Enter new name : ");
            newName = sc.nextLine();
            
            if (!map.containsKey(number)) {
                System.out.println("Contact not found.");
                System.exit(0);
            }
            else {
                map.put(number, newName);
                flag=true;
            }
        }
        // for single value
        else {
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                if (entry.getValue().equals(oldName)) {
                    number = entry.getKey();

                    System.out.print("Enter new name : ");
                    newName = sc.nextLine();

                    map.remove(number, oldName);
                    map.put(number, newName);

                    flag=true;
                    break;
                }
            }
        }
        if (flag) {
            rw.write(map);
            System.out.println("Name changed sucessfully");
        }
        sc.close();
    }

    // to change contact
    public void changeNumber(String oldNumber) {
        Scanner sc = new Scanner(System.in);

        String name;
        if (map.containsKey(oldNumber)) {
            System.out.print("Enter new number : ");
            String newNumber = sc.nextLine();
            name = map.get(oldNumber);
            map.remove(oldNumber);
            map.put(newNumber, name);
            rw.write(map);
            System.out.println("Contact number is edited.");
        }
        else {
            System.out.println("Number not found.");
        }
        sc.close();
    }

}
