package Food;
import java.util.*;

public class FoodDatabase {
    private Map<String, Food> foodMap = new HashMap<String, Food>();

    public void setFoodMap(Map<String, Food> foodMap) {
        this.foodMap = foodMap;
    }

    public Map<String, Food> getFoodMap() {
        return foodMap;
    }
    
    public void addFoodData() {        
        Food food1 = new Food("A001", "South-Indian", 40, true);
        foodMap.put("Dosa", food1);
        Food food2 = new Food("A002", "North-Indian", 50, true);
        foodMap.put("Chapathi", food2);
    }

    public void printFoodData() {
        System.out.println(Arrays.asList(foodMap));
    }
}
