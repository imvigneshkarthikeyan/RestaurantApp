package Order;

import java.util.*;

import Restaurant.Food;

public class Order {
    private String orderID;
    private String userID;
    private String userName;
    private String restaurantID;
    private String restaurantName;
    private Map<Food, Integer> orderedFoodList;

    public String getOrderID() {
        return this.orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRestaurantID() {
        return this.restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Map<Food, Integer> getOrderedFoodList() {
        return orderedFoodList;
    }

    public void setOrderedFoodList(Map<Food, Integer> orderedFoodList) {
        this.orderedFoodList = orderedFoodList;
    }

    //Constructor for Order
    public Order(String orderID, String userID, String userName, String restaurantID, String restaurantName, Map<Food, Integer> cartMap) {
        this.orderID = orderID;
        this.userID = userID;
        this.userName = userName;
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.orderedFoodList = cartMap;
    }

    public Order() {
        this.orderID = getOrderID();
        this.userID = getUserID();
        this.userName = getUserName();
        this.restaurantID = getRestaurantID();
        this.restaurantName = getRestaurantName();
        this.orderedFoodList = getOrderedFoodList();
    }
    
}
