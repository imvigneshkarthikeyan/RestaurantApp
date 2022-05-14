package Restaurant;

import java.util.*;

public class RestaurantDatabase {
    Restaurant restaurant = new Restaurant();
    private ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>() {{
        add(new Restaurant("A2B", "MultiCusine", "Madipakkam", "044-22423932", 400, "a2bmad@abc.com", "123", a2bMenu));
        add(new Restaurant("KFC", "FastFood", "Nanganallur", "87913287912", 600, "kfcnag@abc.com", "123", kfcMenu));
    }};

    public void setRestaurantList(ArrayList<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void printRestaurantData() {
        for (Restaurant restaurant : restaurantList) {
            System.out.println(restaurant);
        }
    }

    public void printRestaurantDataWithIndex() {
        int index = 0;
        for (Restaurant restaurant : restaurantList) {
            System.out.print("Index Number: " + index++ + "| ");
            System.out.println(restaurant);
        }
    }

    private Map<String, Food> a2bMenu = new HashMap<String, Food>() {
        {
            put("Dosa", new Food("South-Indian", 50, true));
            put("ButterChicken", new Food("North-Indian", 200, false));
        }
    };

    private Map<String, Food> kfcMenu = new HashMap<String, Food>() {
        {
            put("Rice & Gravy", new Food("Indian", 300, true));
            put("Crispy Chicken", new Food("FastFood", 200, false));
        }
    };

    public void printFoodData(Map<String, Food> foodMap) {
        System.out.println(Arrays.asList(foodMap));
    }
}
