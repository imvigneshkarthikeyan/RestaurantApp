package Main;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;
import SuperAdmin.SuperAdmin;
import Admin.*;
import Restaurant.*;
import Customer.*;
import Order.OrderDatabase;

public class MainApplication {
    public void displayWelcomeMessage() {
        drawDoubleLine();
        displayLineWithTitle("Welcome to Food ordering application!");
        drawDoubleLine();
    }
    public void selectUserType() {
        drawLine();
        int option = 1;
        AdminDatabase adminDatabase = new AdminDatabase();
        RestaurantDatabase restaurantDatabase = new RestaurantDatabase();
        Restaurant restaurant = new Restaurant();
        CustomerDatabase customerDatabase = new CustomerDatabase();
        Customer customer = new Customer();
        OrderDatabase orderDatabase = new OrderDatabase();
        while (option == 1 || option == 2 || option == 3 || option ==4) {
            System.out.println("Enter to Login as: \n1. SuperAdmin \n2. Admin \n3. Restaurant \n4. Customer \n5. Quit");
            drawLine();
            option = scanner.nextInt();
            optionValidator(option, 1, 5);
            switch (option) {
                case 1:
                    SuperAdmin superAdmin = new SuperAdmin();
                    superAdmin.loginAsSuperAdmin(adminDatabase);
                    break;
                case 2:
                    AdminAuthenticator adminAuthenticator = new AdminAuthenticator();
                    adminAuthenticator.authenticateAdmin(adminDatabase, restaurantDatabase, customerDatabase);
                    break;
                case 3:
                    RestaurantAuthenticator restaurantAuthenticator = new RestaurantAuthenticator();
                    restaurantAuthenticator.authenticateRestaurant(restaurantDatabase);
                    break;
                case 4:
                    CustomerAuthenticator customerAuthenticator = new CustomerAuthenticator();
                    customerAuthenticator.showSignUpSignIn(restaurantDatabase, customerDatabase, customer, orderDatabase, restaurant);
                    break;
                case 5:
                    System.out.println("Quitting the application");
                    break;
                default:
                    break;
            }   
            drawDoubleLine();
        }
    }
}
