package Restaurant;

import java.util.*;

public class RestaurantDatabase {
    Restaurant restaurant = new Restaurant();
    private ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>() {{
        add(new Restaurant("A2B", "MultiCusine", "Madipakkam", "044-22423932", 400, "a2b@abc.com", "123"));
        add(new Restaurant("KFC", "FastFood", "Nanganallur", "87913287912", 600, "kfc@abc.com", "123"));
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

    protected Map<String, ArrayList<Food>> foodMap = new HashMap<String, ArrayList<Food>>(){{
        put("a2b@abc.com", new ArrayList<Food>(){{
            add(new Food("Dosa", "South-Indian", 40, true));
            add(new Food("Chapathi", "North-Indian", 50, true));
        }});
        put("kfc@abc.com", new ArrayList<Food>(){{
            add(new Food("Rice", "Indian", 300, true));
            add(new Food("CrispyChicken", "FastFood", 200, false));
        }});
    }};

    public Map<String, ArrayList<Food>> getFoodMap() {
        return foodMap;
    }

    public void setFoodMap(Map<String, ArrayList<Food>> foodMap) {
        this.foodMap = foodMap;
    }

    public void printFoodData(Map<String, ArrayList<Food>> foodMap) {
        System.out.println(Arrays.asList(foodMap));
    }

}
