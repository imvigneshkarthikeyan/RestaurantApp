package Restaurant;

import static Utilities.UiUtils.*;
import java.util.*;

public class RestaurantDatabase {
    Restaurant restaurant = new Restaurant();
    RestaurantTypeEnum type1 = RestaurantTypeEnum.Cafe;
    RestaurantTypeEnum type2 = RestaurantTypeEnum.CasualDining;
    RestaurantTypeEnum type3 = RestaurantTypeEnum.MultiCusine;
    RestaurantTypeEnum type4 = RestaurantTypeEnum.Pizzerias;
    RestaurantTypeEnum type5 = RestaurantTypeEnum.FastFood;

    private ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>() {{
        add(new Restaurant("A2B", type2, "Madipakkam", "044-22423932", 400, "a2b@abc.com", "123"));
        add(new Restaurant("KFC", type4, "Nanganallur", "87913287912", 600, "kfc@abc.com", "123"));
    }};

    public void setRestaurantList(ArrayList<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void printRestaurantData() {
        for (Restaurant restaurant : restaurantList) {
            drawLine();
            System.out.println(restaurant);
        }
        drawDoubleLine();
    }

    public void printRestaurantDataWithIndex() {
        int index = 0;
        for (Restaurant restaurant : restaurantList) {
            drawLine();
            System.out.print("Index Number: " + index++ + "| ");
            System.out.println(restaurant);
        }
        drawDoubleLine();
    }

    FoodTypeEnum foodType1 = FoodTypeEnum.SouthIndian;
    FoodTypeEnum foodType2 = FoodTypeEnum.NorthIndian;
    FoodTypeEnum foodType3 = FoodTypeEnum.Chinese;
    FoodTypeEnum foodType4 = FoodTypeEnum.Italian;
    FoodTypeEnum foodType5 = FoodTypeEnum.Desert;

    protected Map<String, ArrayList<Food>> foodMap = new HashMap<String, ArrayList<Food>>(){{
        put("a2b@abc.com", new ArrayList<Food>(){{
            add(new Food("Dosa", foodType1, 40, true));
            add(new Food("Chapathi", foodType2, 50, true));
        }});
        put("kfc@abc.com", new ArrayList<Food>(){{
            add(new Food("Rice", foodType1, 300, true));
            add(new Food("ChickenNoodles", foodType3, 200, false));
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
