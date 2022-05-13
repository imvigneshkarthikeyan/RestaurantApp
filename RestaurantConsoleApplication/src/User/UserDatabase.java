package User;

import java.util.*;

public class UserDatabase {
    private Map<String, User> userMap = new HashMap<String, User>();

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void addUserData() {
        User user1 = new User("ABC34578", "Vicky", "9791674810", "123", true);
        userMap.put("vicky@gmail.com", user1);
        User user2 = new User("ABC97812", "Rahul", "8791327891", "123", false);
        userMap.put("rahul@gmail.com", user2);
    }

    public void printUserData() {
        System.out.println(Arrays.asList(userMap));
    }
}
