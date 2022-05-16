package Order;

import java.util.*;

public class OrderDatabase {
    private ArrayList<Order> orderList = new ArrayList<Order>();
    private ArrayList<CartItem> cartItems;

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setCartItem(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public ArrayList<CartItem> getCartItem() {
        return cartItems;
    }

    public void printOrderData() {
        for (Order order : orderList) {
            System.out.println(order);
        }
    }
}
