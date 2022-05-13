package Admin;
import java.util.*;

public class AdminDatabase {
    private Map<String, Admin> adminMap = new HashMap<String, Admin>();

    public void setAdminMap(Map<String, Admin> adminMap) {
        this.adminMap = adminMap;
    }
    public Map<String, Admin> getAdminMap() {
        return adminMap;
    }

    public void addAdminData() {
        Admin admin1 = new Admin("30IYU238", "Ram", "7891237891", "123");
        adminMap.put("admin1@abc.com", admin1); 
        Admin admin2 = new Admin("40IYU237", "Raj", "7899871233", "123");
        adminMap.put("admin2@abc.com", admin2);
    }

    public void printAdminData() {
        System.out.println(Arrays.asList(adminMap));
    }
    
}
