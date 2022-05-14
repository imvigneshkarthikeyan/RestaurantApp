package Order;

import java.util.*;

import Restaurant.Food;

public class Cart {
    private Map<Food, Integer> cartMap = new HashMap<Food, Integer>();

    public void setCartMap(Map<Food, Integer> cartMap) {
        this.cartMap = cartMap;
    }

    public Map<Food, Integer> getCartMap() {
        return cartMap;
    }
}
