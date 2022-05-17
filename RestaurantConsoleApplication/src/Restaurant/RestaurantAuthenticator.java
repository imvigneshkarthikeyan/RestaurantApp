package Restaurant;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import Order.OrderDatabase;

public class RestaurantAuthenticator {
    public void authenticateRestaurant(RestaurantDatabase restaurantDatabase, OrderDatabase orderDatabase) {
        int option = 1;
        while (option == 1) {
            drawDoubleLine();
            System.out.println("Enter the Login Id: ");
            String enteredID = scanner.next();
            drawLine();
            for (Restaurant restaurant : restaurantDatabase.getRestaurantList()) {
                if (restaurant.getLoginID().equals(enteredID)) {
                    System.out.println("ID is correct");
                    validatePasswordForRestaurant(restaurant, enteredID, restaurantDatabase, orderDatabase);
                    option = 2;
                    break;
                } else {
                    drawDoubleLine();
                    System.out.println("Login ID is wrong\nEnter 1: To try again\nEnter 2: Go Back");
                    option = scanner.nextInt();
                    break;
                }           
            }
        }
    }

    public void validatePasswordForRestaurant(Restaurant restaurant, String enteredID, RestaurantDatabase restaurantDatabase, OrderDatabase orderDatabase) {
        int option = 1;
        while (option == 1) {
            System.out.println("Enter password: ");
            String enteredPassword = readPassword();
            drawLine();
            if (restaurant.getLoginPassword().equals(enteredPassword)) {
                drawLine();
                System.out.println("Login Successful");
                displayLineTitleAndUser("Welcome", restaurant.getRestaurantName() + " Restaurant");
                RestaurantFunctions restaurantFunctions = new RestaurantFunctions();
                restaurantFunctions.executeRestaurantFunction(enteredID, restaurant, restaurantDatabase, orderDatabase);
                option = 2;
            } else {
                System.out.println("Password is wrong\nEnter 1: To try again\nEnter 2: Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            }
        }
    }
}
