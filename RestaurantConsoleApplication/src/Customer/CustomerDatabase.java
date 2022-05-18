package Customer;

import java.util.*;

import Order.CartItem;
import Restaurant.FoodTypeEnum;

public class CustomerDatabase {
    private Map<String, Customer> customerMap = new HashMap<String, Customer>(){{
        put("vicky@gmail.com", new Customer("Vicky", "9791674810", "123", true));
        put("rahul@gmail.com", new Customer("Rahul", "8791327891", "123", false));
    }};

    public void setCustomerMap(Map<String, Customer> customerMap) {
        this.customerMap = customerMap;
    }

    public Map<String, Customer> getCustomerMap() {
        return customerMap;
    }

    FoodTypeEnum foodType1 = FoodTypeEnum.SouthIndian;
    FoodTypeEnum foodType2 = FoodTypeEnum.NorthIndian;
    FoodTypeEnum foodType3 = FoodTypeEnum.Chinese;
    FoodTypeEnum foodType4 = FoodTypeEnum.Italian;
    FoodTypeEnum foodType5 = FoodTypeEnum.Desert;

    private Map<String, ArrayList<CartItem>> cartItems = new HashMap<String, ArrayList<CartItem>>(){{
        put("vicky@gmail.com", new ArrayList<CartItem>(){{
            add(new CartItem("Dosa", foodType1, 40, true, 2));
            add(new CartItem("Chapathi", foodType2, 40, true, 2));
        }});
        put("rahul@gmail.com", new ArrayList<CartItem>() {{
            add(new CartItem("Dosa", foodType1, 40, true, 3));
        }});
    }};

    public Map<String, ArrayList<CartItem>> getCartItems() {
        return cartItems;
    } 
    public void setCartItem(Map<String, ArrayList<CartItem>> cartItems) {
        this.cartItems = cartItems;
    }

    public void printCustomerData() {
        System.out.println(customerMap.toString().replace("{", "").replace("}", "").replace("[", "").replace("]", "").replace(",", ""));
    }
}
