package Restaurant;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class RestaurantAuthenticator {
    public void authenticateRestaurant(RestaurantDatabase restaurantDatabase) {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        for (Restaurant restaurant : restaurantDatabase.getRestaurantList()) {
            if (restaurant.getrestaurantLoginId().equals(enteredID)) {
                System.out.println("ID is correct, enter password: ");
                String enteredPassword = readPassword();
                if (restaurant.getrestaurantLoginPassword().equals(enteredPassword)) {
                    System.out.println("LoginSuccessful");
                }
            } else {
                System.out.println("Invalid id");
            }
        }
    }
}
