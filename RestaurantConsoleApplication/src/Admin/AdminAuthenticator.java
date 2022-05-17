package Admin;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import Customer.CustomerDatabase;
import Restaurant.RestaurantDatabase;

public class AdminAuthenticator {
    public void authenticateAdmin(AdminDatabase adminDatabase, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase) {
        int option = 1;
        scanner.nextLine();
        while (option == 1) {
            drawDoubleLine();
            System.out.println("Enter the Login Id: ");
            String enteredID = scanner.nextLine();
            if (adminDatabase.getAdminMap().containsKey(enteredID)==false) {
                drawDoubleLine();
                System.out.println("Login ID is wrong\nEnter 1: To try again\nEnter 2: Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                drawLine();
                System.out.println("ID is crt.");
                drawLine();
                authenticatePasswordForAdmin(enteredID, adminDatabase, restaurantDatabase, customerDatabase);
                option = 2;
            }
        }
        
    }

    public void authenticatePasswordForAdmin(String enteredID, AdminDatabase adminDatabase, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase) {
        int option = 1;
        while(option == 1) {
            drawDoubleLine();
            System.out.println("Enter Password: ");
            String enteredPassword = readPassword();
            if (adminDatabase.getAdminMap().get(enteredID).getLoginPassword().equals(enteredPassword)==false) {
                System.out.println("Password is wrong\nEnter 1: To try again\nEnter 2: Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                drawLine();
                System.out.println("Password is right");
                displayLineTitleAndUser("Welcome Admin ", adminDatabase.getAdminMap().get(enteredID).getAdminName());
                AdminFunctions adminFunctions = new AdminFunctions();
                adminFunctions.executeAdminFunction(restaurantDatabase, customerDatabase);
                option = 2;
            }
        }
        drawDoubleLine();
    }
}
