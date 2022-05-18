package Customer;

import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Order.CartItem;
import Order.Order;
import Order.OrderDatabase;
import Restaurant.Food;
import Restaurant.Restaurant;
import Restaurant.RestaurantDatabase;

public class CustomerFunctions {
    
    public void signUp(CustomerDatabase customerDatabase) {
        int option = 1;
        scanner.nextLine();
        Customer customer = new Customer();
        while (option == 1) {
            drawDoubleLine();
            System.out.println("Enter the new Login ID: ");
            customer.setLoginID(scanner.nextLine());
            if (customerDatabase.getCustomerMap().containsKey(customer.getLoginID())) {
                drawDoubleLine();
                System.out.println("This Login ID already exists\nEnter 1: To try again\nEnter 2: Go Back and login");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                drawLine();
                System.out.println("Set your new password: ");
                customer.setLoginPassword(scanner.nextLine());
                drawLine();
                System.out.println("Enter your name: ");
                customer.setNameOfuser(scanner.nextLine());
                drawLine();
                System.out.println("Enter your phone number: ");
                customer.setPhoneNumberOfUser(scanner.nextLine());
                while (customer.getPhoneNumberOfUser().length() != 10) {
                    System.out.println("Please enter a valid 10 digit phone number \n Eg: 9876543210");
                    customer.setPhoneNumberOfUser(scanner.nextLine());
                }
                drawLine();
                System.out.println("Enter 1: To become premium user \nEnter 2: To skip ");
                int premiumUserOption = scanner.nextInt();
                if (premiumUserOption == 1) {
                    customer.setPremiumUser(true);
                } else {
                    customer.setPremiumUser(false);
                }
                drawLine();
                customerDatabase.getCustomerMap().put(customer.getLoginID(), new Customer(customer.getNameOfuser(),
                        customer.getPhoneNumberOfUser(), customer.getLoginPassword(), customer.isPremiumUser()));
                System.out.println("New User with ID " + customer.getLoginID() + " created successfully");        
                drawDoubleLine();
                option = 2;
            }
        }
    }

    public void signIn(RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, Restaurant restaurant) {
        int option = 1;
        scanner.nextLine();
        while (option == 1) {
            drawDoubleLine();
            System.out.println("Enter the Login Id: ");
            String enteredID = scanner.nextLine();
            if (customerDatabase.getCustomerMap().containsKey(enteredID)==false) {
                drawDoubleLine();
                System.out.println("Login ID is wrong\nEnter 1: To try again\nEnter 2: Go Back and try SignUp");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                if (customerDatabase.getCustomerMap().containsKey(enteredID)) {
                    drawLine();
                    System.out.println("ID is Correct");
                    authenticatePasswordForCustomer(enteredID, restaurantDatabase, customerDatabase, orderDatabase, restaurant);
                    option = 2;
                }
            }
        }
    }

    public void authenticatePasswordForCustomer(String enteredID, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, Restaurant restaurant) {
        int option = 1;
        while (option == 1) {
            drawDoubleLine();
            System.out.println("ID is crt, now enter the password.");
            String enteredPassword = readPassword();
            if (customerDatabase.getCustomerMap().get(enteredID).getLoginPassword().equals(enteredPassword)==false) {
                System.out.println("Password is wrong\nEnter 1: To try again\nEnter 2: Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                drawLine();
                System.out.println("Password is right");
                displayLineTitleAndUser("Welcome ", customerDatabase.getCustomerMap().get(enteredID).getNameOfuser());
                executeCustomerFunction(enteredID, restaurantDatabase, customerDatabase, orderDatabase,restaurant);
                option = 2;
            }
        }
        drawDoubleLine();
    }

    public void searchRestaurant(String enteredID, RestaurantDatabase restaurantDatabase,
            CustomerDatabase customerDatabase, OrderDatabase orderDatabase) {
        scanner.nextLine();
        int option = 1;
        drawDoubleLine();
        restaurantDatabase.printRestaurantData();
        while (option == 1) {
            System.out.println("Enter the name of Restaurant");
            String searchedRestaurant = scanner.nextLine();
            if (restaurantDatabase.getRestaurantList().stream().map(Restaurant::getRestaurantName)
                    .anyMatch(r -> r.equalsIgnoreCase(searchedRestaurant)) == false) {
                System.out.println("Restaurant is not available\nEnter 1: To try again\nEnter 2: Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                for (Restaurant restaurant : restaurantDatabase.getRestaurantList()) {
                    drawLine();
                    if (restaurant.getRestaurantName().equalsIgnoreCase(searchedRestaurant)) {
                        System.out.println("RestaurantFound!");
                        System.out.println(restaurant);
                        // Function for list foods and search food
                        showOptionsForSearchFoodAndCart(enteredID, restaurantDatabase, customerDatabase,
                                searchedRestaurant, restaurant, orderDatabase);
                    }
                }
                option = 2;
            }
        }
        drawDoubleLine();
    }

    public void showOptionsForSearchFoodAndCart(String enteredID, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase,String searchedRestaurant, Restaurant restaurant, OrderDatabase orderDatabase) {
        int option = 1;
        while (option == 1|| option == 2) {
            try {
                drawDoubleLine();
                System.out.println("Enter 1: Go to Foods \nEnter 2: View Cart \nEnter 3: Go back");
                option = scanner.nextInt();
                optionValidator(option, 1, 3);
                drawLine();
                if (restaurantDatabase.getRestaurantList().stream().map(Restaurant::getRestaurantName)
                        .anyMatch(r -> r.equalsIgnoreCase(searchedRestaurant))) {
                    System.out.println("ID is correct");
                    for (Restaurant res : restaurantDatabase.getRestaurantList()) {
                        if (res.getLoginID().equals(enteredID)) {
                            restaurant.setRestaurantName(res.getRestaurantName());
                            restaurant.setLoginID(res.getLoginID());
                        }
                    }
                }
                switch (option) {
                    case 1:
                        searchFood(enteredID, restaurant, restaurantDatabase, customerDatabase);
                        break;
                    case 2:
                        viewCart(enteredID, customerDatabase, orderDatabase, restaurant);
                        break;
                    case 3:
                        System.out.println("Going Back");
                    default:
                        break;
                }
            } catch (NullPointerException e) {
                System.out.println("Add food and come to cart, Going back");
                option = 3;
            }
            
        }
    }

    public void searchFood(String enteredID, Restaurant restaurant, RestaurantDatabase restaurantDatabase, CustomerDatabase customerDatabase) {
        drawDoubleLine();
        scanner.nextLine();
        String restaurantID = restaurant.getLoginID();
        System.out.println(restaurantDatabase.getFoodMap().get(restaurantID).toString().replace("{", "")
                .replace("}", "").replace("[", "").replace("]", "").replace(",", ""));
        int option = 1;
        while(option == 1) {
            drawDoubleLine();
            System.out.println("Enter 1: To Search Food and add to cart\nEnter 2: To Go Back");
            try {
                option = scanner.nextInt();
                optionValidator(option, 1, 2);
                scanner.nextLine();
                switch (option) {
                    case 1:
                        drawLine();
                        int searchOption = 1;
                        while (searchOption == 1) {
                            System.out.println("Enter the food to search: ");
                            String searchedFood = scanner.nextLine();
                            if (restaurantDatabase.getFoodMap().get(restaurantID).stream().map(Food::getFoodName)
                                    .anyMatch(f -> f.equalsIgnoreCase(searchedFood)) == false) {
                                System.out.println("Food is not available\nEnter 1: To try again\nEnter 2: Go Back");
                                option = scanner.nextInt();
                                scanner.nextLine();
                            } else {
                                for (Food food : restaurantDatabase.getFoodMap().get(restaurantID)) {
                                    drawLine();
                                    if (food.getFoodName().equalsIgnoreCase(searchedFood)) {
                                        System.out.println("FoodFound!");
                                        System.out.println(food);
                                        // Function to add food to cart
                                        addFoodToCart(enteredID, food, customerDatabase);
                                    }
                                }
                                drawDoubleLine();
                                searchOption = 2;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Going Back");
                        break;
                    default:
                        break;
                }                
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, try again");
                option = 1;
            }
        }
    }

    public void addFoodToCart(String enteredID, Food food, CustomerDatabase customerDatabase) {
        drawLine();
        int option = 1;
        while (option == 1) {
            System.out.println("Enter the quantity to be added: ");
            int quantity = scanner.nextInt();
            if (quantity > 0) {
                if (customerDatabase.getCartItems().get(enteredID) == null) {
                    customerDatabase.getCartItems().put(enteredID, new ArrayList<CartItem>() {
                        {
                            add(new CartItem(food.getFoodName(), food.getFoodType(), food.getFoodCost(), food.isVeg(),
                                    quantity));
                        }
                    });
                } else {
                    customerDatabase.getCartItems().get(enteredID)
                            .add(new CartItem(food.getFoodName(), food.getFoodType(),
                                    food.getFoodCost(), food.isVeg(), quantity));
                }
                System.out.println("Food: " + food.getFoodName() + " of " + quantity + " quantity added to cart");
                option = 2;
            } else {
                System.out.println("Enter a valid positive number.");
                option = 1;
            }
        }
        
        
    }

    public void viewCart(String enteredID, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, Restaurant restaurant) {
        //Itmes in cart
        if (customerDatabase.getCartItems().get(enteredID).isEmpty()) {
            System.out.println("The cart is empty");
        } else {
            System.out.println(customerDatabase.getCartItems().get(enteredID).toString().replace("{", "")
                    .replace("}", "").replace("[", "").replace("]", "").replace(",", ""));
        }
        int option = 1;
        while (option == 1 || option == 2) {
            try {
                drawDoubleLine();
            System.out.println("Enter 1: View Total Cost and Place Order \nEnter 2: Remove items from cart \nEnter 3: To Go Back");
            option = scanner.nextInt();
            optionValidator(option, 1, 3);
            switch (option) {
                case 1:
                    if (customerDatabase.getCartItems().get(enteredID).isEmpty()) {
                        System.out.println("As the cart is empty, you can't view total/place Order");
                    } else if (customerDatabase.getCartItems() == null) {
                        System.out.println("As the order was placed, the cart is empty now");
                    } else {
                        viewTotalCost(enteredID, customerDatabase, orderDatabase, restaurant);
                    }
                    break;
                case 2:
                    if (customerDatabase.getCartItems().get(enteredID).isEmpty()) {
                        System.out.println("As the cart is empty, you can't remove further");
                    } else {
                        removeItemsFromCart(enteredID, customerDatabase);
                    }
                    break;
                case 3:
                    System.out.println("Going Back");
                    break;
                default:
                    break;
            }
        } catch (NullPointerException e) {
            System.out.println("Can't place order, going back");
            option = 3;
        }
            } 
            
    }

    public void viewTotalCost(String enteredID, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, Restaurant restaurant) {
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
        placeOrder(enteredID, customerDatabase, orderDatabase, restaurant, totalCost);
        
    }

    public String generateOrderID() {
        String ID = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return ID;
    }

    public String getDateAndTimeNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void placeOrder(String enteredID, CustomerDatabase customerDatabase, OrderDatabase orderDatabase, Restaurant restaurant, double totalCost) {
        String userName = customerDatabase.getCustomerMap().get(enteredID).getNameOfuser();
        orderDatabase.getOrderList().add(new Order(generateOrderID(), getDateAndTimeNow(), enteredID, userName, restaurant.getLoginID(),restaurant.getRestaurantName(), customerDatabase.getCartItems().get(enteredID), totalCost));
        drawLine();
        System.out.println("Order Placed Successfully");
        removeAllFromCart(customerDatabase);
    }

    public void removeItemsFromCart(String enteredID, CustomerDatabase customerDatabase) {
        int i = 0;
        for (CartItem cartItem : customerDatabase.getCartItems().get(enteredID)) {
            drawLine();
            System.out.println(i + " | " +cartItem);
            i++;
        }
        drawLine();
        int option = 1;
        while (option == 1) {
            System.out.println("Enter the index number of the cart item to be removed: ");
            int index = scanner.nextInt();
            if (index < customerDatabase.getCartItems().get(enteredID).size() && index >= 0 ) {
                customerDatabase.getCartItems().get(enteredID).remove(index);
                System.out.println("Cart after removal is: " + customerDatabase.getCartItems().get(enteredID));
                option = 2;
            } else {
                System.out.println("Enter a valid index number");
            }
        }
    }

    public void removeAllFromCart(CustomerDatabase customerDatabase) {
        customerDatabase.getCartItems().clear();
    }

    public void viewOrderHistory(String enteredID, OrderDatabase orderDatabase) {
        List<Order> orderHistory = new ArrayList<Order>();
        drawDoubleLine();
        for (Order order : orderDatabase.getOrderList()) {
            if (order.getUserID().equalsIgnoreCase(enteredID)) {
                orderHistory.add(order);
            }
        }
        if (orderHistory.isEmpty()) {
            System.out.println("No Orders Till Now.");
        } else {
            System.out.println(orderHistory.toString().replace("[", "").replace("]", "").replace(",", ""));
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
            try {
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
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, try again");
                option = 1;
            }
        }
    }
}
