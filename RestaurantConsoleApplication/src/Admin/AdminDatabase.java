package Admin;
import java.util.*;

public class AdminDatabase {
    private Map<String, Admin> adminMap = new HashMap<String, Admin>() {{
        put("admin1@abc.com", new Admin("Ram", "7891237891", "123"));
        put("admin2@abc.com", new Admin("Raj", "7899871233", "123"));
    }};

    public void setAdminMap(Map<String, Admin> adminMap) {
        this.adminMap = adminMap;
    }
    public Map<String, Admin> getAdminMap() {
        return adminMap;
    }

    public void printAdminData() {
        System.out.println(Arrays.asList(adminMap).toString().replace("{", "").replace("}", "").replace("[", "").replace("]", "").replace(",", ""));
    }
    
}
