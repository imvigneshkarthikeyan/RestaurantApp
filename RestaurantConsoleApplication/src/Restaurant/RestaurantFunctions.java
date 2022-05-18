package Restaurant;

import java.util.ArrayList;
import java.util.Iterator;

import Order.Order;
import Order.OrderDatabase;

import static Utilities.ValidatorUtils.*;
import static Utilities.UiUtils.*;

public class RestaurantFunctions {

    public void viewData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        if (restaurantDatabase.foodMap.get(restaurant.getLoginID()) == null) {
            restaurantDatabase.foodMap.put(restaurant.getLoginID(), new ArrayList<Food>() {
                {
                }
            });
        }
        if (restaurantDatabase.foodMap.get(restaurant.getLoginID()).isEmpty()) {
            System.out.println("No food added Till Now.");
        } else {
            drawLine();
            System.out.println(restaurantDatabase.foodMap.get(restaurant.getLoginID()).toString().replace("[", "")
                    .replace("]", "").replace(",", ""));
        }
    }

    public void addData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        scanner.nextLine();
        Food food = new Food();
        drawDoubleLine();
        int option = 1;
        while (option == 1) {
            if (restaurantDatabase.foodMap.get(restaurant.getLoginID()) == null) {
                restaurantDatabase.foodMap.put(restaurant.getLoginID(), new ArrayList<Food>() {{}});
            }
            System.out.println("Enter the food name: ");
            food.setFoodName(scanner.nextLine());
            if (restaurantDatabase.getFoodMap().get(restaurant.getLoginID()).stream().map(Food::getFoodName).anyMatch(f -> f.equalsIgnoreCase(food.getFoodName()))) {
                System.out.println(
                        "This food already exists,\nEnter 1: To Try again and create different food \nEnter 2: To Go Back");
                drawLine();
                option = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
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
                    System.out.println("Enter the food cost: ");
                    food.setFoodCost(scanner.nextDouble());
                    drawLine();
                    System.out.println("Enter 1: if Veg? \nEnter any other: if NonVeg ");
                    int foodPreference = scanner.nextInt();
                    if (foodPreference == 1) {
                        food.setVeg(true);
                    } else {
                        food.setVeg(false);
                    }
                    drawLine();
                    // if (restaurantDatabase.foodMap.get(restaurant.getLoginID()) == null) {
                    //     restaurantDatabase.foodMap.put(restaurant.getLoginID(), new ArrayList<Food>() {
                    //         {
                    //             add(new Food(food.getFoodName(), food.getFoodType(), food.getFoodCost(), food.isVeg()));
                    //         }
                    //     });
                    // } else {
                        restaurantDatabase.foodMap.get(restaurant.getLoginID()).add(
                                new Food(food.getFoodName(), food.getFoodType(), food.getFoodCost(), food.isVeg()));
                    // }
                    drawLine();
                    option = 2;
                    break;
                }
            }
        }
    

    public void deleteData(Restaurant restaurant, RestaurantDatabase restaurantDatabase) {
        scanner.nextLine();
        Iterator<Food> foodItems = restaurantDatabase.foodMap.get(restaurant.getLoginID()).iterator();
        int i = 0;
        while (foodItems.hasNext()) {
            drawLine();
            System.out.println(i + " | " + foodItems.next());
            i++;
        }
        drawDoubleLine();
        int option = 1;
        while (option == 1) {
            System.out.println("Enter the index of the food to be removed: ");
            int indexToBeRemoved = scanner.nextInt();
            if (indexToBeRemoved < restaurantDatabase.foodMap.get(restaurant.getLoginID()).size() && indexToBeRemoved >= 0) {
                restaurantDatabase.foodMap.get(restaurant.getLoginID()).remove(indexToBeRemoved);
                option = 2;
            } else {
                System.out.println("Enter a valid index number");
                option = 1;
            }
        }
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
        int option = 1;
        while (option == 1) {
            System.out.println("Enter the index of the food whose cost to be updated: ");
            int index = scanner.nextInt();
            if (index < restaurantDatabase.foodMap.get(restaurant.getLoginID()).size()
                    && index >= 0) {
                drawLine();
                System.out.println("Enter the cost that has to be updated: ");
                restaurantDatabase.foodMap.get(restaurant.getLoginID()).get(index).setFoodCost(scanner.nextDouble());
                option = 2;
            } else {
                System.out.println("Enter a valid index number");
                option = 1;
            }
        }
    }

    public void viewOrders(OrderDatabase orderDatabase, Restaurant restaurant) {
        if (orderDatabase.getOrderList().isEmpty()) {
            System.out.println("No Orders Till now");
        } else {
            for (Order order : orderDatabase.getOrderList()) {
                drawLine();
                if (order.getRestaurantID().equalsIgnoreCase(restaurant.getLoginID())) {
                    System.out.println(order.toString().replace("[", "").replace("]", "").replace(",", ""));
                }
            }
        }
        drawDoubleLine();
    }

    public void displayOptionsForRestaurant() {
        System.out.println("Enter the option: \n1. View All Foods \n2. Add new Food \n3. Delete a Food \n4. Edit cost of Food \n5. View Order History \n6. Logout");
        drawLine();
    }

    public void executeRestaurantFunction(Restaurant restaurant, RestaurantDatabase restaurantDatabase, OrderDatabase orderDatabase) {
        int option = 1;
        // restaurant.setLoginID(enteredID);
        // System.out.println(restaurant.getLoginID());
        while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) {
            drawDoubleLine();
            displayOptionsForRestaurant();
            try {
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
                        if (restaurantDatabase.foodMap.get(restaurant.getLoginID()).isEmpty() == false) {
                            deleteData(restaurant, restaurantDatabase);
                        } else {
                            System.out.println("As no food is available, you can't delete food");
                        }
                        break;
                    case 4:
                        if (restaurantDatabase.foodMap.get(restaurant.getLoginID()).isEmpty() == false) {
                            editData(restaurant, restaurantDatabase);
                        } else {
                            System.out.println("As no food is available, you can't edit food's cost");
                        }
                        break;
                    case 5:
                        viewOrders(orderDatabase, restaurant);
                        break;
                    case 6:
                        System.out.println("Logging out from Restaurant portal");
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
