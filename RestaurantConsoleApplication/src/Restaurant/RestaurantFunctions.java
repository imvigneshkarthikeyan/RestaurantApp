package Restaurant;

import java.util.ArrayList;
import java.util.Iterator;

import Order.Order;
import Order.OrderDatabase;

import static Utilities.ValidatorUtils.*;
import static Utilities.UiUtils.*;

public class RestaurantFunctions {

    public void viewData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        if (restaurantDatabase.foodMap.get(restaurant.getLoginID())==null) {
            System.out.println("No food added Till Now.");
        } else {
            drawLine();
            System.out.println(restaurantDatabase.foodMap.get(restaurant.getLoginID()));
        }
    }

    public void addData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        scanner.nextLine();
        Food food = new Food();
        drawDoubleLine();
        System.out.println("Enter the food name: ");
        food.setFoodName(scanner.nextLine());
        drawLine();
        System.out.println("Enter the type of Restaurant: \n1.SouthIndian \n2.NorthIndian \n3.Chinese \n4.Italian \n5.Desert ");
        int optionForEnum = scanner.nextInt();
        switch (optionForEnum) {
            case 1:
                FoodTypeEnum type1 = FoodTypeEnum.SouthIndian;
                food.setFoodType(type1);
                break;
            case 2:
                FoodTypeEnum type2 = FoodTypeEnum.NorthIndian;
                food.setFoodType(type2);
                break;
            case 3:
                FoodTypeEnum type3 = FoodTypeEnum.Chinese;
                food.setFoodType(type3);
                break;
            case 4:
                FoodTypeEnum type4 = FoodTypeEnum.Italian;
                food.setFoodType(type4);
                break;
            case 5:
                FoodTypeEnum type5 = FoodTypeEnum.Desert;
                food.setFoodType(type5);
                break;
            default:
                break;
        }
        drawLine();
        // scanner.nextLine();
        System.out.println("Enter the food cost: ");
        food.setFoodCost(scanner.nextDouble());
        drawLine();
        System.out.println("Enter 1: if Veg? \nEnter 2: if NonVeg ");
        int option = scanner.nextInt();
        if (option == 1) {
        food.setVeg(true);
        } else {
        food.setVeg(false);
        }
        drawLine();
        if (restaurantDatabase.foodMap.get(restaurant.getLoginID())==null) {
            restaurantDatabase.foodMap.put(restaurant.getLoginID(), new ArrayList<Food>() {
                {
                    add(new Food(food.getFoodName(), food.getFoodType(), food.getFoodCost(), food.isVeg()));
                }
            });
        } else {
            restaurantDatabase.foodMap.get(restaurant.getLoginID()).add(new Food(food.getFoodName(), food.getFoodType(), food.getFoodCost(), food.isVeg()));
        }
        drawLine();
    }

    public void deleteData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        scanner.nextLine();
        System.out.println("Enter the index of the food to be removed: ");
        Iterator<Food> foodItems = restaurantDatabase.foodMap.get(restaurant.getLoginID()).iterator();
        int i = 0;
        while (foodItems.hasNext()) {
            drawLine();
            System.out.println(i + " | " + foodItems.next());
            i++;
        }
        drawDoubleLine();
        restaurantDatabase.foodMap.get(restaurant.getLoginID()).remove(scanner.nextInt());
    }

    public void editData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        scanner.nextLine();
        Iterator<Food> foodItems = restaurantDatabase.foodMap.get(restaurant.getLoginID()).iterator();
        int i = 0;
        while (foodItems.hasNext()) {
            drawLine();
            System.out.println(i + " | " + foodItems.next());
            i++;
        }
        drawDoubleLine();
        System.out.println("Enter the index of the food whose cost to be updated: ");
        int index = scanner.nextInt();
        drawLine();
        System.out.println("Enter the cost that has to be updated: ");
        restaurantDatabase.foodMap.get(restaurant.getLoginID()).get(index).setFoodCost(scanner.nextDouble());
    }

    public void viewOrders(OrderDatabase orderDatabase, Restaurant restaurant) {
        if (orderDatabase.getOrderList().isEmpty()) {
            System.out.println("No Orders Till now");
        } else {
            for (Order order : orderDatabase.getOrderList()) {
                drawLine();
                if (order.getRestaurantID().equalsIgnoreCase(restaurant.getLoginID())) {
                    System.out.println(order);
                }
            }
        }
        drawDoubleLine();
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
