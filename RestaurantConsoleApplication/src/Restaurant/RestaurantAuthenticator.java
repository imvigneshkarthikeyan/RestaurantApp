package Restaurant;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import Order.OrderDatabase;

public class RestaurantAuthenticator {
    public void authenticateRestaurant(RestaurantDatabase restaurantDatabase, OrderDatabase orderDatabase, Restaurant restaurant) {
        int option = 1;
        while (option == 1) {
            drawDoubleLine();
            System.out.println("Enter the Login Id: ");
            String enteredID = scanner.next();
            drawLine();
            if (restaurantDatabase.getRestaurantList().stream().map(Restaurant::getLoginID).anyMatch(r -> r.equalsIgnoreCase(enteredID))) {
                System.out.println("ID is correct");
                for (Restaurant res : restaurantDatabase.getRestaurantList()) {
                    if (res.getLoginID().equals(enteredID)) {
                        restaurant.setRestaurantName(res.getRestaurantName());
                        restaurant.setLoginID(res.getLoginID());
                    }
                }
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

    public void validatePasswordForRestaurant(Restaurant restaurant, String enteredID, RestaurantDatabase restaurantDatabase, OrderDatabase orderDatabase) {
        int option = 1;
        while (option == 1) {
            System.out.println("Enter password: ");
            String enteredPassword = readPassword();
            drawLine();
            if (restaurantDatabase.getRestaurantList().stream().map(Restaurant::getLoginPassword).anyMatch(r -> r.equalsIgnoreCase(enteredPassword))) {
                drawLine();
                System.out.println("Login Successful");
                displayLineTitleAndUser("Welcome", restaurant.getRestaurantName() + " Restaurant");
                RestaurantFunctions restaurantFunctions = new RestaurantFunctions();
                restaurantFunctions.executeRestaurantFunction(restaurant, restaurantDatabase, orderDatabase);
                option = 2;
            } else {
                System.out.println("Password is wrong\nEnter 1: To try again\nEnter 2: Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            }
        }
    }
}
