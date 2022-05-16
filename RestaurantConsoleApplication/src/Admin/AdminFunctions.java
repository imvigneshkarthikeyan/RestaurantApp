package Admin;

import Restaurant.Restaurant;
import Restaurant.RestaurantDatabase;
import Restaurant.RestaurantTypeEnum;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import Customer.CustomerDatabase;

public class AdminFunctions {

    public void viewData(RestaurantDatabase restaurantDatabase) {
        // View Restaurant Details
        restaurantDatabase.printRestaurantData();        
    }

    public void addData(RestaurantDatabase restaurantDatabase) {
        // Adding new restaurant
        scanner.nextLine();
        Restaurant restaurant = new Restaurant();
        drawDoubleLine();
        System.out.println("Enter the Restaurant Login ID: ");
        restaurant.setLoginID(scanner.nextLine());
        drawLine();
        System.out.println("Enter the password for restaurant: ");
        restaurant.setLoginPassword(scanner.nextLine());
        drawLine();
        System.out.println("Enter the Restaurant Name: ");
        restaurant.setRestaurantName(scanner.nextLine());
        drawLine();
        System.out.println("Enter the type of Restaurant: \n1.Cafe \n2.CasualDining \n3.MultiCusine \n4.Pizzerias \n5.FastFood ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                RestaurantTypeEnum type1 = RestaurantTypeEnum.Cafe;
                restaurant.setRestaurantType(type1);
                break;
            case 2:
                RestaurantTypeEnum type2 = RestaurantTypeEnum.CasualDining;
                restaurant.setRestaurantType(type2);
                break;
            case 3:
                RestaurantTypeEnum type3 = RestaurantTypeEnum.MultiCusine;
                restaurant.setRestaurantType(type3);
                break;
            case 4:
                RestaurantTypeEnum type4 = RestaurantTypeEnum.Pizzerias;
                restaurant.setRestaurantType(type4);
                break;
            case 5:
                RestaurantTypeEnum type5 = RestaurantTypeEnum.FastFood;
                restaurant.setRestaurantType(type5);
                break;
            default:
                break;
        }
        drawLine();
        scanner.nextLine();
        System.out.println("Enter the location of Restaurant: ");
        restaurant.setRestaurantLocation(scanner.nextLine());
        drawLine();
        System.out.println("Enter the phone number of Restaurant: ");
        restaurant.setRestaurantPhoneNumber(scanner.nextLine());
        drawLine();
        System.out.println("Enter the average cost for 2: ");
        restaurant.setRestaurantAvgCost(scanner.nextDouble());
        drawLine();
        restaurantDatabase.getRestaurantList().add(new Restaurant(restaurant.getRestaurantName(), restaurant.getRestaurantType(), restaurant.getRestaurantLocation(), restaurant.getRestaurantPhoneNumber(), restaurant.getRestaurantAvgCost(), restaurant.getLoginID(), restaurant.getLoginPassword()));
        drawDoubleLine();
    }

    public void deleteData(RestaurantDatabase restaurantDatabase) {
        // Delete restaurant
        restaurantDatabase.printRestaurantDataWithIndex();
        System.out.println("Enter the index of the restaurant that has to be removed: ");
        int index = scanner.nextInt();
        restaurantDatabase.getRestaurantList().remove(index);
    }

    public void viewCustomerData(CustomerDatabase customerDatabase) {
        drawLine();
        customerDatabase.printCustomerData();
        drawDoubleLine();
    }

    public void removeCustomerData(CustomerDatabase customerDatabase) {
        scanner.nextLine();
        drawLine();
        System.out.println("Enter the login ID to be removed: ");
        String IDtoBeRemoved = scanner.nextLine();
        customerDatabase.getCustomerMap().remove(IDtoBeRemoved);
        drawDoubleLine();
    }

    public void displayOptionsForAdmin() {
        System.out.println("Enter the option: \n1. View All Restaurants \n2. Add new Restaurant \n3. Delete a Restaurant \n4. View all Customers \n5. Delete a Customer \n6. Logout");
        drawLine();
    }

    public void executeAdminFunction(RestaurantDatabase restaurantDatabase, CustomerDatabase  customerDatabase) {
        int option = 1;
        while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) {
            drawDoubleLine();
            displayOptionsForAdmin();
            option = scanner.nextInt();
            optionValidator(option, 1, 6);
            switch (option) {
                case 1:
                    viewData(restaurantDatabase);
                    break;
                case 2:
                    addData(restaurantDatabase);
                    break;
                case 3:
                    deleteData(restaurantDatabase);
                    break;
                case 4:
                    viewCustomerData(customerDatabase);
                    break;
                case 5:
                    removeCustomerData(customerDatabase);
                    break;
                case 6:
                    System.out.println("Logging out from Admin portal");
                default:
                    break;
            }
        }
    }
    
}
