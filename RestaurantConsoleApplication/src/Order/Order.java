package Order;

import java.util.*;

public class Order {
    private String orderID;
    private String userID;
    private String userName;
    private String restaurantID;
    private String restaurantName;
    private ArrayList<CartItem> cartItems;
    private double totalBillAmount;
    private String dateTimeLog;

    public String getDateTimeLog() {
        return this.dateTimeLog;
    }

    public void setDateTimeLog(String dateTimeLog) {
        this.dateTimeLog = dateTimeLog;
    }

    public double getTotalBillAmount() {
        return this.totalBillAmount;
    }

    public void setTotalBillAmount(double totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }

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
    public Order(String orderID, String dateTimeLog, String userID, String userName, String restaurantID, String restaurantName, ArrayList<CartItem> cartItems, double totalBillAmount) {
        this.orderID = orderID;
        this.dateTimeLog = dateTimeLog;
        this.userID = userID;
        this.userName = userName;
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.cartItems = cartItems;
        this.totalBillAmount = totalBillAmount;
    }

    public Order() {
        this.orderID = getOrderID();
        this.dateTimeLog = getDateTimeLog();
        this.userID = getUserID();
        this.userName = getUserName();
        this.restaurantID = getRestaurantID();
        this.restaurantName = getRestaurantName();
        this.cartItems = getCartItems();
        this.totalBillAmount = getTotalBillAmount();
    }

    // To display Order information
    @Override
    public String toString() {
        return "Order Time: " + dateTimeLog + "\n"
                + " | Order ID: " + orderID + "\n"
                + " | User ID: " + userID + "\n"
                + " | User Name: " + userName + "\n"
                + " | Restaurant ID: " + restaurantID + "\n"
                + " | Restaurant Name: " + restaurantName + "\n"
                + " | Food Items: " + cartItems + "\n"
                + " | Total Amount: " + totalBillAmount + "\n"
                + "---------------------------------------------------------------------------------------------------------------------------------------------------"
                + "\n";
    }
    
}
