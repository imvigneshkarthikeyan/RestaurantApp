package Restaurant;

import java.util.ArrayList;
import java.util.Iterator;

import Order.Order;
import Order.OrderDatabase;

import static Utilities.ValidatorUtils.*;
import static Utilities.UiUtils.*;

public class RestaurantFunctions {

    public void viewData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        System.out.println(restaurantDatabase.foodMap.get(restaurant.getLoginID()));
    }

    public void addData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        Food food = new Food();
        System.out.println("Enter the food name: ");
        food.setFoodName(scanner.next());
        System.out.println("Enter the food type: ");
        food.setFoodType(scanner.next());
        System.out.println("Enter the food cost: ");
        food.setFoodCost(scanner.nextDouble());
        System.out.println("Enter 1: if Veg? \n Enter 2: if NonVeg ");
        int option = scanner.nextInt();
        if (option == 1) {
        food.setVeg(true);
        } else {
        food.setVeg(false);
        }
        if (restaurantDatabase.foodMap.get(restaurant.getLoginID())==null) {
            restaurantDatabase.foodMap.put(restaurant.getLoginID(), new ArrayList<Food>() {
                {
                    add(new Food(food.getFoodName(), food.getFoodType(), food.getFoodCost(), food.isVeg()));
                }
            });
        } else {
            restaurantDatabase.foodMap.get(restaurant.getLoginID()).add(new Food(food.getFoodName(), food.getFoodType(), food.getFoodCost(), food.isVeg()));
        }
    }

    public void deleteData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        System.out.println("Enter the index of the food to be removed: ");
        Iterator<Food> foodItems = restaurantDatabase.foodMap.get(restaurant.getLoginID()).iterator();
        // for (ArrayList<Food> food : restaurantDatabase.foodMap.get(restaurant.getLoginID()).iterator()) {
        //     System.out.println(Arrays.asList(food));
        // }
        int i = 0;
        while (foodItems.hasNext()) {
            System.out.println(i + " | " + foodItems.next());
            i++;
        }
        restaurantDatabase.foodMap.get(restaurant.getLoginID()).remove(scanner.nextInt());
    }

    public void editData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        System.out.println("Enter the index of the food whose cost to be updated: ");
        Iterator<Food> foodItems = restaurantDatabase.foodMap.get(restaurant.getLoginID()).iterator();
        int i = 0;
        while (foodItems.hasNext()) {
            System.out.println(i + " | " + foodItems.next());
            i++;
        }
        System.out.println("Enter the cost that has to be updated: ");
        restaurantDatabase.foodMap.get(restaurant.getLoginID()).get(scanner.nextInt()).setFoodCost(scanner.nextDouble());
    }

    public void viewOrders(OrderDatabase orderDatabase, Restaurant restaurant) {
        for (Order order : orderDatabase.getOrderList()) {
            if (order.getRestaurantID().equalsIgnoreCase(restaurant.getLoginID())) {
                System.out.println(order);
            }
        }
    }

    public void displayOptionsForRestaurant() {
        System.out.println("Enter the option: \n1. View All Foods \n2. Add new Food \n3. Delete a Food \n4. Edit cost of Food \n5. View Order History \n6. Logout");
        drawLine();
    }

    public void executeRestaurantFunction(String enteredID, Restaurant restaurant, RestaurantDatabase restaurantDatabase, OrderDatabase orderDatabase) {
        int option = 1;
        restaurant.setLoginID(enteredID);
        // System.out.println(restaurant.getLoginID());
        while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) {
            drawDoubleLine();
            displayOptionsForRestaurant();
            option = scanner.nextInt();
            optionValidator(option, 1, 6);
            switch (option) {
                case 1:
                    viewData(restaurant, restaurantDatabase);
                    break;
                case 2:
                    addData(restaurant, restaurantDatabase);
                    break;
                case 3:
                    deleteData(restaurant, restaurantDatabase);
                    break;
                case 4:
                    editData(restaurant, restaurantDatabase);
                    break;
                case 5:
                    viewOrders(orderDatabase, restaurant);
                    break;
                case 6:
                    System.out.println("Logging out from Restaurant portal");
                default:
                    break;
            }
        }
    }
}
