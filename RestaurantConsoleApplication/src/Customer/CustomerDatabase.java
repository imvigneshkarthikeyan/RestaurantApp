package Customer;

import java.util.*;

import Order.CartItem;

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

    private Map<String, ArrayList<CartItem>> cartItems = new HashMap<String, ArrayList<CartItem>>(){{
        put("vicky@gmail.com", new ArrayList<CartItem>(){{
            add(new CartItem("A2B", "a2b@abc.com", "Vicky", "Dosa", "South", 40, true, 2));
        }});
        put("rahul@gmail.com", new ArrayList<CartItem>() {{
            add(new CartItem("A2B", "a2b@abc.com", "Rahul", "Dosa", "South", 40, true, 3));
        }});
    }};

    public Map<String, ArrayList<CartItem>> getCartItems() {
        return cartItems;
    } 
    public void setCartItem(Map<String, ArrayList<CartItem>> cartItems) {
        this.cartItems = cartItems;
    }

    public void printCustomerData() {
        System.out.println(Arrays.asList(customerMap));
    }
}
