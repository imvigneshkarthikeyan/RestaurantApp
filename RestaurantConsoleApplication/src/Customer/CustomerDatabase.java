package Customer;

import java.util.*;

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

    public void printCustomerData() {
        System.out.println(Arrays.asList(customerMap));
    }
}
