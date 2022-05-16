package Customer;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import java.util.ArrayList;
import java.util.UUID;

import Order.CartItem;
import Order.Order;
import Order.OrderDatabase;
import Restaurant.Food;
import Restaurant.Restaurant;
import Restaurant.RestaurantDatabase;

public class CustomerFunctions {
    
    public void signUp(CustomerDatabase customerDatabase) {
        Customer customer = new Customer();
        drawDoubleLine();
        System.out.println("Enter the new Login ID: ");
        customer.setLoginID(scanner.next());
        drawLine();
        System.out.println("Set your new password: ");
        customer.setLoginPassword(scanner.next());
        drawLine();
        System.out.println("Enter your name: ");
        customer.setNameOfuser(scanner.next());
        drawLine();
        System.out.println("Enter your phone number: ");
        customer.setPhoneNumberOfUser(scanner.next());
        drawLine();
        System.out.println("Enter 1: To become premium user \nEnter 2: To skip ");
        int option = scanner.nextInt();
        if (option == 1) {
            customer.setPremiumUser(true);
        } else {
            customer.setPremiumUser(false);
        }
        drawLine();
        customerDatabase.getCustomerMap().put(customer.getLoginID(), new Customer(customer.getNameOfuser(), customer.getPhoneNumberOfUser(), customer.getLoginPassword(), customer.isPremiumUser()));
        drawDoubleLine();
    }

    public void signIn(RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, Restaurant restaurant) {
        drawDoubleLine();
        System.out.println("Enter the Login Id: ");
        String enteredID = scanner.next();
        if (customerDatabase.getCustomerMap().containsKey(enteredID)) {
            drawLine();
            System.out.println("ID is crt, now enter the password.");
            String enteredPassword = readPassword();
            if (customerDatabase.getCustomerMap().get(enteredID).getLoginPassword().equals(enteredPassword)) {
                drawLine();
                System.out.println("Password is right");
                displayLineTitleAndUser("Welcome ", customerDatabase.getCustomerMap().get(enteredID).getNameOfuser());
                executeCustomerFunction(enteredID, restaurantDatabase, customerDatabase, orderDatabase, restaurant);
            }
        }
    }

    public void searchRestaurant(String enteredID, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase,OrderDatabase orderDatabase) {
        drawDoubleLine();
        restaurantDatabase.printRestaurantData();
        System.out.println("Enter the name of Restaurant");
        String searchedRestaurant = scanner.next();
        for (Restaurant restaurant : restaurantDatabase.getRestaurantList()) {
        drawLine();
            if (restaurant.getRestaurantName().equalsIgnoreCase(searchedRestaurant)) {
                System.out.println("RestaurantFound!");
                System.out.println(restaurant);
                // Function for list foods and search food
                showOptionsForSearchFoodAndCart(enteredID, restaurantDatabase, customerDatabase, searchedRestaurant, restaurant, orderDatabase);
            }
        }
        drawDoubleLine();
    }

    public void showOptionsForSearchFoodAndCart(String enteredID, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase,String searchedRestaurant, Restaurant restaurant, OrderDatabase orderDatabase) {
        int option = 1;
        while (option == 1|| option == 2) {
            drawDoubleLine();
            System.out.println("Enter 1: Go to Foods \nEnter 2: View Cart \nEnter 3: Go back");
            option = scanner.nextInt();
            optionValidator(option, 1, 3);
            drawLine();
            switch (option) {
                case 1:
                    searchFood(enteredID, searchedRestaurant, restaurant, restaurantDatabase, customerDatabase);
                    break;
                case 2:
                    viewCart(enteredID, customerDatabase, orderDatabase, searchedRestaurant);
                    break;
                case 3:
                    System.out.println("Going Back");
                default:
                    break;
            }
        }
    }

    public void searchFood(String enteredID, String searchedRestaurant, Restaurant restaurant, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase) {
        drawDoubleLine();
        restaurant.setRestaurantName(searchedRestaurant);
        String restaurantID = restaurant.getRestaurantName().toLowerCase() + "@abc.com";
        System.out.println(restaurantDatabase.getFoodMap().get(restaurantID));
        int option = 1;
        while(option == 1) {
            drawDoubleLine();
            System.out.println("Enter 1: To Search Food and add to cart\nEnter 2: To Go Back");
            option = scanner.nextInt();
            optionValidator(option, 1, 2);
            switch (option) {
                case 1:
                    drawLine();
                    System.out.println("Enter the food to search: ");
                    String searchedFood = scanner.next();
                    for (Food food : restaurantDatabase.getFoodMap().get(restaurantID)) {
                        drawLine();
                        if (food.getFoodName().equalsIgnoreCase(searchedFood)) {
                            System.out.println("FoodFound!");
                            System.out.println(food);
                            // Function to add food to cart
                            addFoodToCart(searchedRestaurant, enteredID, food, customerDatabase);
                        }
                    }
                    drawDoubleLine();
                    break;
                case 2:
                    System.out.println("Going Back");
                    break;
                default:
                    break;
            }
        }
    }

    public void addFoodToCart(String searchedRestaurant, String enteredID, Food food, CustomerDatabase customerDatabase) {
        drawLine();
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

    public void viewCart(String enteredID, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, String searchedRestaurant) {
        //Itmes in cart
        System.out.println(customerDatabase.getCartItems().get(enteredID));
        int option = 1;
        while (option == 1 || option == 2) {
            drawDoubleLine();
            System.out.println("Enter 1: View Total Cost and Place Order \nEnter 2: Remove items from cart \nEnter 3: To Go Back");
            option = scanner.nextInt();
            optionValidator(option, 1, 3);
            switch (option) {
                case 1:
                    viewTotalCost(enteredID, customerDatabase, orderDatabase, searchedRestaurant);
                    break;
                case 2:
                    removeItemsFromCart(enteredID, customerDatabase, orderDatabase, searchedRestaurant);
                    break;
                case 3:
                    System.out.println("Going Back");
                    break;
                default:
                    break;
            }
        }
    }

    public void viewTotalCost(String enteredID, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, String searchedRestaurant) {
        ArrayList<Double> totalCostList = new ArrayList<>();
        for (CartItem cartItem : customerDatabase.getCartItems().get(enteredID)) {
            totalCostList.add(cartItem.getFoodCost() * cartItem.getQuantity());
        }
        double totalCost = 0;
        for (Double element : totalCostList) {
            totalCost += element;
        }
        // Discount for premium customer
        if (customerDatabase.getCustomerMap().get(enteredID).isPremiumUser()==true) {
        drawDoubleLine();
        System.out.println("The total bill amount is: " + totalCost);
        drawLine();
        System.out.println("But as you are a premium customer 10% discount is made.");
        drawLine();
        totalCost = totalCost - (totalCost*0.10);
        System.out.println("Now the total bill is: " + totalCost);
        drawDoubleLine();
        } else {
            //Bill amount for normal customer
            System.out.println("The total bill amount is: " + totalCost);
            drawDoubleLine();
        }
        placeOrder(enteredID, customerDatabase, orderDatabase, searchedRestaurant, totalCost);
    }

    public String generateOrderID() {
        String ID = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return ID;
    }

    public void placeOrder(String enteredID, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, String searchedRestaurant, double totalCost) {
        String userName = customerDatabase.getCustomerMap().get(enteredID).getNameOfuser();
        orderDatabase.getOrderList().add(new Order(generateOrderID(), enteredID, userName, searchedRestaurant+"@abc.com",searchedRestaurant, customerDatabase.getCartItems().get(enteredID), totalCost));
        drawLine();
        System.out.println("Order Placed Successfully");
        removeAllFromCart(customerDatabase);
    }

    public void removeItemsFromCart(String enteredID, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, String searchedRestaurant) {
        int i = 0;
        for (CartItem cartItem : customerDatabase.getCartItems().get(enteredID)) {
            drawLine();
            System.out.println(i + " | " +cartItem);
            i++;
        }
        drawLine();
        System.out.println("Enter the index number of the cart item to be removed: ");
        int itemToBeRemoved = scanner.nextInt();
        customerDatabase.getCartItems().get(enteredID).remove(itemToBeRemoved);
        System.out.println("Cart after removal is: " + customerDatabase.getCartItems().get(enteredID));
    }

    public void removeAllFromCart(CustomerDatabase customerDatabase) {
        customerDatabase.getCartItems().clear();
    }

    public void viewOrderHistory(String enteredID, OrderDatabase orderDatabase) {
        drawDoubleLine();
        for (Order order : orderDatabase.getOrderList()) {
            if (order.getUserID().equalsIgnoreCase(enteredID)) {
                System.out.println(order);
            }
        }
    }

    public void displayOptionsForCustomer() {
        System.out.println("Enter 1: Search Restaurant \nEnter 2: View Order History \nEnter 3: Logout");
    }
    public void executeCustomerFunction(String enteredID, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, Restaurant restaurant) {
        int option = 1;
        while (option == 1 || option == 2) {
            drawDoubleLine();
            displayOptionsForCustomer();
            option = scanner.nextInt();
            optionValidator(option, 1, 3);
            switch (option) {
                case 1:
                    searchRestaurant(enteredID, restaurantDatabase, customerDatabase, orderDatabase);
                    break;
                case 2:
                    viewOrderHistory(enteredID, orderDatabase);
                    break;
                case 3:
                    System.out.println("Logging out from Customer portal");
                    break;
                default:
                    break;
            }
        }
    }
}
