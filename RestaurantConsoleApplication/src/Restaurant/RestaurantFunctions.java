package Restaurant;

import java.util.Arrays;
import static Utilities.ValidatorUtils.*;
import static Utilities.UiUtils.*;

public class RestaurantFunctions {

    public void viewData(RestaurantDatabase restaurantDatabase) {
        Restaurant restaurant = new Restaurant();
        System.out.println(Arrays.asList(restaurant.getMenuCard()));
    }

    public void addData(RestaurantDatabase restaurantDatabase) {
        Restaurant restaurant = new Restaurant();
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
        restaurant.getMenuCard().put(food.getFoodName(), new Food(food.getFoodType(), food.getFoodCost(), food.isVeg()));
    }

    public void deleteData(RestaurantDatabase restaurantDatabase) {
        Restaurant restaurant = new Restaurant();
        System.out.println("Enter the food to be removed: ");
        restaurant.getMenuCard().remove(scanner.next());
    }

    public void editData(RestaurantDatabase restaurantDatabase) {
        Restaurant restaurant = new Restaurant();
        System.out.println("Enter the food name whose cost has to be updated: ");
        System.out.println("Enter the cost that has to be updated: ");
        restaurant.getMenuCard().get(scanner.next()).setFoodCost(scanner.nextDouble());
    }

    public void viewOrders() {
        //TODO
    }

    public void displayOptionsForRestaurant() {
        System.out.println("Enter the option: \n1. View All Foods \n2. Add new Food \n3. Delete a Food \n4. Edit cost of Food \n5. View Order History \n6. Logout");
        drawLine();
    }

    public void executeRestaurantFunction(RestaurantDatabase restaurantDatabase) {
        int option = 1;
        while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) {
            displayOptionsForRestaurant();
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
                    editData(restaurantDatabase);
                    break;
                case 5:
                    viewOrders();
                    break;
                case 6:
                    System.out.println("Logging out from Restaurant portal");
                default:
                    break;
            }
        }
    }
}
