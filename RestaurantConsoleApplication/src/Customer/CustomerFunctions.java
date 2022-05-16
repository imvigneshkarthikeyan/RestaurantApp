package Customer;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import java.util.ArrayList;

import Order.CartItem;
import Order.OrderDatabase;
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

    public void signIn(RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase, Customer customer, OrderDatabase orderDatabase) {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        if (customerDatabase.getCustomerMap().containsKey(enteredID)) {
            System.out.println("ID is crt, now enter the password.");
            String enteredPassword = readPassword();
            if (customerDatabase.getCustomerMap().get(enteredID).getLoginPassword().equals(enteredPassword)) {
                System.out.println("Password is right");
                executeCustomerFunction(enteredID, restaurantDatabase, customer, customerDatabase, orderDatabase);
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
        int option = 1;
        while(option == 1) {
            System.out.println("Enter 1: To Search Food and add to cart\nEnter 2: To Go Back");
            option = scanner.nextInt();
            optionValidator(option, 1, 3);
            switch (option) {
                case 1:
                    System.out.println("Enter the food to search: ");
                    String searchedFood = scanner.next();
                    for (Food food : restaurantDatabase.getFoodMap().get(restaurantID)) {
                        if (food.getFoodName().equalsIgnoreCase(searchedFood)) {
                            System.out.println("FoodFound!");
                            System.out.println(food);
                            // Function to add food to cart
                            addFoodToCart(restaurant, enteredID, food, customerDatabase, customer);
                        } else {
                            System.out.println("The food is not available, try different!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Going Back");
                default:
                    break;
            }
        }
    }

    public void addFoodToCart(Restaurant restaurant, String enteredID, Food food, CustomerDatabase customerDatabase, Customer customer) {
        System.out.println("Enter the quantity to be added: ");
        if (customerDatabase.getCartItems().get(enteredID)==null) {
            customerDatabase.getCartItems().put(enteredID, new ArrayList<CartItem>(){{
                add(new CartItem(food.getFoodName(), food.getFoodType(), food.getFoodCost(), food.isVeg(), scanner.nextInt()));
            }});
        } else {
            customerDatabase.getCartItems().get(enteredID).add(new CartItem(food.getFoodName(), food.getFoodType(),
                    food.getFoodCost(), food.isVeg(), scanner.nextInt()));
        }
    }

    public void viewCart(String enteredID, CustomerDatabase customerDatabase, OrderDatabase orderDatabase) {
        //Itmes in cart
        System.out.println(customerDatabase.getCartItems().get(enteredID));
        int option = 1;
        while (option == 1 || option == 2) {
            System.out.println("Enter 1: Place Order \nEnter 2: Remove items from cart \nEnter 3: To Go Back");
            option = scanner.nextInt();
            optionValidator(option, 1, 3);
            switch (option) {
                case 1:
                    //Logic for place order
                        // PaymentCalculator
                        // Add totalCost in CartItem by multiplying it with Quantity.
                    break;
                case 2:
                    removeItemsFromCart(enteredID, customerDatabase, orderDatabase);
                    break;
                case 3:
                    System.out.println("Going Back");
                default:
                    break;
            }
        }
    }

    public void removeItemsFromCart(String enteredID, CustomerDatabase customerDatabase, OrderDatabase orderDatabase) {
        int i = 0;
        for (CartItem cartItem : customerDatabase.getCartItems().get(enteredID)) {
            System.out.println(i + " | " +cartItem);
            i++;
        }
        System.out.println("Enter the index number of the cart item to be removed: ");
        int itemToBeRemoved = scanner.nextInt();
        customerDatabase.getCartItems().get(enteredID).remove(itemToBeRemoved);
        System.out.println("Items after removal");
        viewCart(enteredID, customerDatabase, orderDatabase);
    }

    public void displayOptionsForCustomer() {
        System.out.println("Enter 1: Search Restaurant \nEnter 2: View Cart \nEnter 3: View Order History \nEnter 4: Go Back");
    }
    public void executeCustomerFunction(String enteredID, RestaurantDatabase restaurantDatabase, Customer customer, CustomerDatabase customerDatabase, OrderDatabase orderDatabase) {
        int option = 1;
        while (option == 1 || option == 2) {
            drawDoubleLine();
            displayOptionsForCustomer();
            option = scanner.nextInt();
            optionValidator(option, 1, 4);
            switch (option) {
                case 1:
                    searchRestaurant(enteredID, restaurantDatabase, customer, customerDatabase);
                    break;
                case 2:
                    viewCart(enteredID, customerDatabase, orderDatabase);
                    break;
                case 3:
                    //viewOrderHistory
                    break;
                case 4:
                    System.out.println("Logging out from Customer portal");
                    break;
                default:
                    break;
            }
        }
    }
}
