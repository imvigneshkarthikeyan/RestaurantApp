package Order;

import java.util.*;

import Food.Food;

public class OrderDatabase {
    private ArrayList<Order> orderList = new ArrayList<>();
    private Map<Food, Integer> cartMap;

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    Order order1 = new Order("O001", "vicky@abc", "Vicky", "a2bmad", "A2B", cartMap);
    Order order2 = new Order("O002", "raj@abc", "Raj", "kfcnag", "KFC", cartMap);

    public void addOrderData() {
        Collections.addAll(orderList, order1, order2);
    }

    public void printOrderData() {
        for (Order order : orderList) {
            System.out.println(order);
        }
    }
}
