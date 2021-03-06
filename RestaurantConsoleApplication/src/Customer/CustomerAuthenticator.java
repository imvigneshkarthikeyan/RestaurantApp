package Customer;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import Order.OrderDatabase;
import Restaurant.Restaurant;
import Restaurant.RestaurantDatabase;

public class CustomerAuthenticator {
    public void showSignUpSignIn(RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, Restaurant restaurant) {
        CustomerFunctions customerFunctions = new CustomerFunctions();
        int option = 1;
        while (option == 1 || option == 2) {
            System.out.println("Enter 1: To Sign in \nEnter 2: New User? Sign Up \nEnter 3: Go Back");
            drawDoubleLine();
            try {
                option = scanner.nextInt();
                optionValidator(option, 1, 3);
                switch (option) {
                    case 1:
                        System.out.println("Signing in");
                        customerFunctions.signIn(restaurantDatabase, customerDatabase, orderDatabase, restaurant);
                        break;
                    case 2:
                        customerFunctions.signUp(customerDatabase);
                        break;
                    case 3:
                        System.out.println("Going Back");
                        break;
                    default:
                        break;
                }                
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input, please try again");
                option = 1;
            }
        }
    }
}
