package Order;

import java.util.*;

public class Order {
    private String orderID;
    private String userID;
    private String userName;
    private String restaurantID;
    private String restaurantName;
    private ArrayList<CartItem> cartItems;

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

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    //Constructor for Order
    public Order(String orderID, String userID, String userName, String restaurantID, String restaurantName, ArrayList<CartItem> cartItems) {
        this.orderID = orderID;
        this.userID = userID;
        this.userName = userName;
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.cartItems = cartItems;
    }

    public Order() {
        this.orderID = getOrderID();
        this.userID = getUserID();
        this.userName = getUserName();
        this.restaurantID = getRestaurantID();
        this.restaurantName = getRestaurantName();
        this.cartItems = getCartItems();
    }
    
}
