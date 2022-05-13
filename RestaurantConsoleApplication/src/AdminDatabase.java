import java.util.*;
import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class AdminDatabase {
    private Map<String, Admin> adminMap = new HashMap<String, Admin>();

    public void addAdminData() {
        Admin admin1 = new Admin("30IYU238", "Ram", "7891237891", "123");
        adminMap.put("admin1@abc.com", admin1); 
        Admin admin2 = new Admin("40IYU237", "Raj", "7899871233", "123");
        adminMap.put("admin2@abc.com", admin2);
    }

    public void printAdminMap() {
        System.out.println(Arrays.asList(adminMap));
    }

    public void authenticateAdmin() {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        if (adminMap.containsKey(enteredID)) {
            System.out.println("ID is crt, now enter the password.");
            String enteredPassword = readPassword();
            if (adminMap.get(enteredID).getAdminLoginPassword().equals(enteredPassword)) {
                System.out.println("Password is right");
            } else {
                System.out.println("Password is wrong");
            }
        }
    }
    
}
