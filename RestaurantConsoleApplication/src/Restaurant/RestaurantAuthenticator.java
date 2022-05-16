package Restaurant;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import Order.OrderDatabase;

public class RestaurantAuthenticator {
    public void authenticateRestaurant(RestaurantDatabase restaurantDatabase, OrderDatabase orderDatabase) {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        for (Restaurant restaurant : restaurantDatabase.getRestaurantList()) {
            if (restaurant.getLoginID().equals(enteredID)) {
                System.out.println("ID is correct, enter password: ");
                String enteredPassword = readPassword();
                if (restaurant.getLoginPassword().equals(enteredPassword)) {
                    System.out.println("Login Successful");
                    RestaurantFunctions restaurantFunctions = new RestaurantFunctions();
                    restaurantFunctions.executeRestaurantFunction(enteredID, restaurant, restaurantDatabase, orderDatabase);
                }
            }
        }
    }
}
