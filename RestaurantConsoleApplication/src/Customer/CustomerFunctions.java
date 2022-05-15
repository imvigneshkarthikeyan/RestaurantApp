package Customer;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import java.util.ArrayList;

import Order.CartItem;
import Restaurant.Food;
import Restaurant.Restaurant;
import Restaurant.RestaurantDatabase;

public class CustomerFunctions {
    
    public void signUp(CustomerDatabase customerDatabase) {
        Customer customer = new Customer();
        System.out.println("Enter the new Login ID: ");
        customer.setLoginID(scanner.next());
        System.out.println("Set your new password: ");
        customer.setLoginPassword(scanner.next());
        System.out.println("Enter your name: ");
        customer.setNameOfuser(scanner.next());
        System.out.println("Enter your phone number: ");
        customer.setPhoneNumberOfUser(scanner.next());
        System.out.println("Enter 1: To become premium user \nEnter 2: To skip ");
        int option = scanner.nextInt();
        if (option == 1) {
            customer.setPremiumUser(true);
        } else {
            customer.setPremiumUser(false);
        }
        customerDatabase.getCustomerMap().put(customer.getLoginID(), new Customer(customer.getNameOfuser(), customer.getPhoneNumberOfUser(), customer.getLoginPassword(), customer.isPremiumUser()));
    }

    public void signIn(RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase, Customer customer) {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        if (customerDatabase.getCustomerMap().containsKey(enteredID)) {
            System.out.println("ID is crt, now enter the password.");
            String enteredPassword = readPassword();
            if (customerDatabase.getCustomerMap().get(enteredID).getLoginPassword().equals(enteredPassword)) {
                System.out.println("Password is right");
                executeCustomerFunction(enteredID, restaurantDatabase, customer, customerDatabase);
            } else {
                System.out.println("Password is wrong");
            }
        }
    }

    public void searchRestaurant(String enteredID, RestaurantDatabase restaurantDatabase, Customer customer, CustomerDatabase customerDatabase) {
        drawDoubleLine();
        restaurantDatabase.printRestaurantData();
        System.out.println("Enter the name of Restaurant");
        String searchedRestaurant = scanner.next();
        for (Restaurant restaurant : restaurantDatabase.getRestaurantList()) {
            if (restaurant.getRestaurantName().equalsIgnoreCase(searchedRestaurant)) {
                System.out.println("RestaurantFound!");
                System.out.println(restaurant);
                // Function for list foods and search food
                searchFood(enteredID, searchedRestaurant, restaurant, restaurantDatabase, customer, customerDatabase);
            } else {
                System.out.println("The restaurant is not available, try other");
            }
        }
    }

    public void searchFood(String enteredID, String searchedRestaurant, Restaurant restaurant, RestaurantDatabase restaurantDatabase, Customer customer, CustomerDatabase customerDatabase) {
        drawDoubleLine();
        restaurant.setRestaurantName(searchedRestaurant);
        String restaurantID = restaurant.getRestaurantName().toLowerCase() + "@abc.com";
        System.out.println(restaurantID);
        System.out.println(restaurantDatabase.getFoodMap().get(restaurantID));
        System.out.println("Enter the food to search: ");
        String searchedFood = scanner.next();
        for (Food food : restaurantDatabase.getFoodMap().get(restaurantID)) {
            if (food.getFoodName().equalsIgnoreCase(searchedFood)) {
                System.out.println("FoodFound!");
                System.out.println(food);
                //Function to add food to cart
                addFoodToCart(restaurant, enteredID, food, customerDatabase, customer);
            } else {
                System.out.println("The food is not available, try different!");
            }
        }
    }

    public void addFoodToCart(Restaurant restaurant, String enteredID, Food food, CustomerDatabase customerDatabase, Customer customer) {
        System.out.println("Enter the quantity to be added: ");
        if (customerDatabase.getCartItems().get(enteredID)==null) {
            customerDatabase.getCartItems().put(enteredID, new ArrayList<CartItem>(){{
                add(new CartItem(restaurant.getRestaurantName(), restaurant.getLoginID(), customer.getNameOfuser(), food.getFoodName(), food.getFoodType(), food.getFoodCost(), food.isVeg(), scanner.nextInt()));
            }});
        } else {
            customerDatabase.getCartItems().get(enteredID).add(new CartItem(restaurant.getRestaurantName(),
                    restaurant.getLoginID(), customer.getNameOfuser(), food.getFoodName(), food.getFoodType(),
                    food.getFoodCost(), food.isVeg(), scanner.nextInt()));
        }
        
    }

    public void viewHistory(String enteredID, CustomerDatabase customerDatabase) {
        System.out.println(customerDatabase.getCartItems().get(enteredID));
    }

    public void displayOptionsForCustomer() {
        System.out.println("Enter 1: Search Restaurant \nEnter 2: View History \nEnter 3: Go back");
    }
    public void executeCustomerFunction(String enteredID, RestaurantDatabase restaurantDatabase, Customer customer, CustomerDatabase customerDatabase) {
        int option = 1;
        while (option == 1 || option == 2) {
            drawDoubleLine();
            displayOptionsForCustomer();
            option = scanner.nextInt();
            optionValidator(option, 1, 3);
            switch (option) {
                case 1:
                    searchRestaurant(enteredID, restaurantDatabase, customer, customerDatabase);
                    break;
                case 2:
                    viewHistory(enteredID, customerDatabase);
                    break;
                case 3:
                    System.out.println("Logging out from Customer portal");
                default:
                    break;
            }
        }
    }
}
