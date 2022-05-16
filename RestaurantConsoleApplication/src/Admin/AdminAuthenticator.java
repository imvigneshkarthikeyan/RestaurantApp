package Admin;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import Customer.CustomerDatabase;
import Restaurant.RestaurantDatabase;

public class AdminAuthenticator {
    public void authenticateAdmin(AdminDatabase adminDatabase, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase) {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        if (adminDatabase.getAdminMap().containsKey(enteredID)) {
            System.out.println("ID is crt, now enter the password.");
            String enteredPassword = readPassword();
            if (adminDatabase.getAdminMap().get(enteredID).getLoginPassword().equals(enteredPassword)) {
                System.out.println("Password is right");
                displayLineTitleAndUser("Welcome", "Admin " + adminDatabase.getAdminMap().get(enteredID).getAdminName());
                AdminFunctions adminFunctions = new AdminFunctions();
                adminFunctions.executeAdminFunction(restaurantDatabase, customerDatabase);
            }
        }
    }
}
