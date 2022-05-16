package Order;

import java.util.*;

public class OrderDatabase {
    private ArrayList<Order> orderList = new ArrayList<Order>(){{
        new Order("O001", "vicky@abc", "Vicky", "a2bmad", "A2B", new ArrayList<CartItem>() {{}});
        new Order("O002", "raj@abc", "Raj", "kfcnag", "KFC", new ArrayList<CartItem>() {{}});
    }};
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

    // Order order1 = new Order("O001", "vicky@abc", "Vicky", "a2bmad", "A2B", new ArrayList<CartItem>(){{}});
    // Order order2 = new Order("O002", "raj@abc", "Raj", "kfcnag", "KFC", new ArrayList<CartItem>(){{}});

    // public void addOrderData() {
    //     Collections.addAll(orderList, order1, order2);
    // }

    public void printOrderData() {
        for (Order order : orderList) {
            System.out.println(order);
        }
    }
}
