import java.util.*;

class EditContacts {
    public void changeName(String oldName, String newName) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();

        ReadWrite rw = new ReadWrite();
        map = rw.read();
        System.out.println("Changing name");
        int count = 0;
        // Iterator<Map.Entry<String, String>
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Changing name");
            if (oldName.equals(entry.getValue())) {
                // if multiple numbers are registered
                
                if (count > 1) {
                    System.out.println("Two contacts are available.");
                    System.out.print("Enter contact number : ");
                    String number = sc.nextLine();
                    map.remove(number, oldName);
                    map.put(number, newName);
                // if one number is registered
                } else {
                    map.remove(entry.getValue());
                    map.put(entry.getKey(), newName);
                }
                count=0;
            }
        }
        sc.close();
    }

    public void changeNumber(String oldNumber, String newNumber) {

    }

}
