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
        int option = 1;
        while (option == 1) {
            System.out.println("Enter the Restaurant Login ID: (Hint: Enter restaurant name + abc.com)");
            restaurant.setLoginID(scanner.nextLine());
            if (restaurantDatabase.getFoodMap().containsKey(restaurant.getLoginID())) {
                System.out.println("This Restaurant already exists, \nEnter 1: To Try again and create different ID \nEnter 2: To Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                drawLine();
                System.out.println("Enter the password for restaurant: ");
                restaurant.setLoginPassword(scanner.nextLine());
                drawLine();
                System.out.println("Enter the Restaurant Name: ");
                restaurant.setRestaurantName(scanner.nextLine());
                drawLine();
                System.out.println("Enter the type of Restaurant: \n1.Cafe \n2.CasualDining \n3.MultiCusine \n4.Pizzerias \n5.FastFood ");
                int typeOption = scanner.nextInt();
                switch (typeOption) {
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
                while (restaurant.getRestaurantPhoneNumber().length() != 10) {
                    System.out.println("Please enter a valid 10 digit phone number \n Eg: 9876543210");
                    restaurant.setRestaurantPhoneNumber(scanner.nextLine());
                }
                drawLine();
                System.out.println("Enter the average cost for 2: ");
                restaurant.setRestaurantAvgCost(scanner.nextDouble());
                drawLine();
                restaurantDatabase.getRestaurantList()
                        .add(new Restaurant(restaurant.getRestaurantName(), restaurant.getRestaurantType(),
                                restaurant.getRestaurantLocation(), restaurant.getRestaurantPhoneNumber(),
                                restaurant.getRestaurantAvgCost(), restaurant.getLoginID(),
                                restaurant.getLoginPassword()));
                drawDoubleLine();
                option = 2;
            }
            drawDoubleLine();
        }
    }

    public void deleteData(RestaurantDatabase restaurantDatabase) {
        scanner.nextLine();
        restaurantDatabase.printRestaurantDataWithIndex();
        // Delete restaurant
        int option = 1;
        while (option == 1) {
            System.out.println("Enter the index of the restaurant that has to be removed: ");
            int index = scanner.nextInt();
            if (index < restaurantDatabase.getRestaurantList().size() && index >= 0 ) {
                restaurantDatabase.getRestaurantList().remove(index);
                option = 2;
            } else {
                System.out.println("Enter a valid index number");
                option = 1;
            }
        }
        
    }

    public void viewCustomerData(CustomerDatabase customerDatabase) {
        if (customerDatabase.getCustomerMap().isEmpty()) {
            System.out.println("No customers available till now");
        } else {
            drawLine();
            customerDatabase.printCustomerData();
            drawDoubleLine();
        }
    }

    public void removeCustomerData(CustomerDatabase customerDatabase) {
        scanner.nextLine();
        drawLine();
        int option = 1;
        while (option == 1) {
            System.out.println("Enter the login ID to be removed: ");
            String IDtoBeRemoved = scanner.nextLine();
            if (customerDatabase.getCustomerMap().containsKey(IDtoBeRemoved) == false) {
                System.out.println("There is no such customer ID\nEnter 1: To try again\nEnter 2: To Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                customerDatabase.getCustomerMap().remove(IDtoBeRemoved);
                drawDoubleLine();
                System.out.println("The customer with login ID: " + IDtoBeRemoved + " was removed successfully!");
                drawDoubleLine();
                System.out.println("The customer DB after deleting: ");
                customerDatabase.printCustomerData();
                option = 2;
            }
        }
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
            try {
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
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, try again");
                option = 1;
            }
        }
    }
    
}
