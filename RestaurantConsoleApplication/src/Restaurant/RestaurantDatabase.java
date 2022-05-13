package Restaurant;

import java.util.ArrayList;
import java.util.Collections;

public class RestaurantDatabase {
    private ArrayList<Restaurant> restaurantList = new ArrayList<>();

    public void setRestaurantList(ArrayList<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    Restaurant restaurant1 = new Restaurant("RES001", "A2B", "MultiCusine", "Madipakkam", "044-22423932", 400, "a2bmad@abc.com", "123");
    Restaurant restaurant2 = new Restaurant("RES002", "KFC", "FastFood", "Nanganallur", "87913287912", 600, "kfcnag@abc.com", "123");

    public void addRestaurantData() {
        Collections.addAll(restaurantList, restaurant1,restaurant2);
    }

    public void printRestaurantData() {
        for (Restaurant restaurant : restaurantList) {
            System.out.println(restaurant);
        }
    }
}
