package Customer;

import java.util.*;

public class CustomerDatabase {
    private Map<String, Customer> customerMap = new HashMap<String, Customer>();

    public void setCustomerMap(Map<String, Customer> customerMap) {
        this.customerMap = customerMap;
    }

    public Map<String, Customer> getCustomerMap() {
        return customerMap;
    }

    public void addCustomerData() {
        Customer customer1 = new Customer("Vicky", "9791674810", "123", true);
        customerMap.put("vicky@gmail.com", customer1);
        Customer customer2 = new Customer("Rahul", "8791327891", "123", false);
        customerMap.put("rahul@gmail.com", customer2);
    }

    public void printCustomerData() {
        System.out.println(Arrays.asList(customerMap));
    }
}
