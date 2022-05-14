package Restaurant;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class RestaurantAuthenticator {
    public void authenticateRestaurant(RestaurantDatabase restaurantDatabase) {
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
                    
                }
            } else {
                System.out.println("Invalid id");
            }
        }
    }
}
