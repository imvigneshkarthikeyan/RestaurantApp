import Admin.AdminDatabase;
import Admin.AuthenticateAdmin;


public class Main {
    public static void main(String[] args) throws Exception {
        // drawDoubleLine();
        // SuperAdmin superAdmin = new SuperAdmin();
        AdminDatabase adminDatabase = new AdminDatabase();
        AuthenticateAdmin authenticateAdmin = new AuthenticateAdmin();
        adminDatabase.addAdminData();
        adminDatabase.printAdminMap();
        authenticateAdmin.authenticateAdmin(adminDatabase);
        
    }
}
