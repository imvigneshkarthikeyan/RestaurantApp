package Restaurant;

import java.util.ArrayList;

public class RestaurantDatabase {
    private ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>() {{
        add(new Restaurant("A2B", "MultiCusine", "Madipakkam", "044-22423932", 400, "a2bmad@abc.com", "123"));
        add(new Restaurant("KFC", "FastFood", "Nanganallur", "87913287912", 600, "kfcnag@abc.com", "123"));
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
}
