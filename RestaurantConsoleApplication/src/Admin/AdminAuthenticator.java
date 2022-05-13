package Admin;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class AdminAuthenticator {
    public void authenticateAdmin(AdminDatabase adminDatabase) {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        if (adminDatabase.getAdminMap().containsKey(enteredID)) {
            System.out.println("ID is crt, now enter the password.");
            String enteredPassword = readPassword();
            if (adminDatabase.getAdminMap().get(enteredID).getAdminLoginPassword().equals(enteredPassword)) {
                System.out.println("Password is right");
            } else {
                System.out.println("Password is wrong");
            }
        }
    }
}
