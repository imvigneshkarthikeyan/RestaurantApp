package User;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class UserAuthenticator {
    public void authenticateUser(UserDatabase userDatabase) {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        if (userDatabase.getUserMap().containsKey(enteredID)) {
            System.out.println("ID is crt, now enter the password.");
            String enteredPassword = readPassword();
            if (userDatabase.getUserMap().get(enteredID).getUserLoginPassword().equals(enteredPassword)) {
                System.out.println("Password is right");
            } else {
                System.out.println("Password is wrong");
            }
        }
    }
}
