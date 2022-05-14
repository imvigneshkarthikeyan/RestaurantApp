package Admin;

import Restaurant.Restaurant;
import Restaurant.RestaurantDatabase;
import Utilities.Operations;
import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import Customer.CustomerDatabase;

public class AdminFunctions implements Operations {

    @Override
    public void viewData() {
        // View Restaurant Details
        RestaurantDatabase restaurantDatabase = new RestaurantDatabase();
        restaurantDatabase.printRestaurantData();        
    }

    @Override
    public void addData() {
        // Adding new restaurant
        Restaurant restaurant = new Restaurant();
        RestaurantDatabase restaurantDatabase = new RestaurantDatabase();
        System.out.println("Enter the Restaurant Login ID: ");
        restaurant.setLoginID(scanner.next());
        System.out.println("Enter the password for restaurant: ");
        restaurant.setLoginPassword(scanner.next());
        System.out.println("Enter the Restaurant Name: ");
        restaurant.setRestaurantName(scanner.next());
        System.out.println("Enter the type of Restaurant: ");
        restaurant.setRestaurantType(scanner.next());
        System.out.println("Enter the location of Restaurant: ");
        restaurant.setRestaurantLocation(scanner.next());
        System.out.println("Enter the phone number of Restaurant: ");
        restaurant.setRestaurantPhoneNumber(scanner.next());
        System.out.println("Enter the average cost for 2: ");
        restaurant.setRestaurantAvgCost(scanner.nextDouble());
        restaurantDatabase.getRestaurantList().add(new Restaurant(restaurant.getRestaurantName(), restaurant.getRestaurantType(), restaurant.getRestaurantLocation(), restaurant.getRestaurantPhoneNumber(), restaurant.getRestaurantAvgCost(), restaurant.getLoginID(), restaurant.getLoginPassword()));
        
    }

    @Override
    public void deleteData() {
        // Delete restaurant
        RestaurantDatabase restaurantDatabase = new RestaurantDatabase();
        restaurantDatabase.printRestaurantDataWithIndex();
        System.out.println("Enter the index of the restaurant that has to be removed: ");
        int index = scanner.nextInt();
        restaurantDatabase.getRestaurantList().remove(index);
    }

    public void viewCustomerData() {
        CustomerDatabase customerDatabase = new CustomerDatabase();
        customerDatabase.printCustomerData();
    }

    public void removeCustomerData() {
        CustomerDatabase customerDatabase = new CustomerDatabase();
        System.out.println("Enter the login ID to be removed: ");
        String IDtoBeRemoved = scanner.next();
        customerDatabase.getCustomerMap().remove(IDtoBeRemoved);
    }

    public void displayOptionsForAdmin() {
        System.out.println("Enter the option: \n1. View All Restaurants \n2. Add new Restaurant \n3. Delete a Restaurant \n4. View all Customers \n5. Delete a Customer \n6. Logout");
        drawLine();
    }

    public void executeAdminFunction() {
        int option = 1;
        while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) {
            displayOptionsForAdmin();
            option = scanner.nextInt();
            optionValidator(option, 1, 6);
            switch (option) {
                case 1:
                    viewData();
                    break;
                case 2:
                    addData();
                    break;
                case 3:
                    deleteData();
                    break;
                case 4:
                    viewCustomerData();
                    break;
                case 5:
                    removeCustomerData();
                    break;
                case 6:
                    System.out.println("Logging out from Super admin portal");
                default:
                    break;
            }
        }
    }
    
}
