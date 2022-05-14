package Customer;

import java.util.*;

public class CustomerDatabase {
    private Map<String, Customer> userMap = new HashMap<String, Customer>();

    public void setUserMap(Map<String, Customer> userMap) {
        this.userMap = userMap;
    }

    public Map<String, Customer> getUserMap() {
        return userMap;
    }

    public void addUserData() {
        Customer user1 = new Customer("ABC34578", "Vicky", "9791674810", "123", true);
        userMap.put("vicky@gmail.com", user1);
        Customer user2 = new Customer("ABC97812", "Rahul", "8791327891", "123", false);
        userMap.put("rahul@gmail.com", user2);
    }

    public void printUserData() {
        System.out.println(Arrays.asList(userMap));
    }
}
