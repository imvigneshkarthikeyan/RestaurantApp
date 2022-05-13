// import static Utilities.UiUtils.*;
// import static Utilities.ValidatorUtils.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // drawDoubleLine();
        // SuperAdmin superAdmin = new SuperAdmin();
        AdminDatabase adminDatabase = new AdminDatabase();
        adminDatabase.addAdminData();
        adminDatabase.printAdminMap();
        adminDatabase.authenticateAdmin();
        // superAdmin.loginAsSuperAdmin();
        // displayLineTitleAndUser("Welcome", "Super Admin");
        // displayLineWithTitle("Order History");
        // drawLine();
    }
}
