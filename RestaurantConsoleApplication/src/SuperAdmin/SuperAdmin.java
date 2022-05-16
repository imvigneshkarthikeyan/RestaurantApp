package SuperAdmin;
import static Utilities.ValidatorUtils.*;
import Admin.AdminDatabase;

public class SuperAdmin {
    private final String SUPER_ADMIN_LOGIN_ID = "superadmin@abc.com";
    private final String SUPER_ADMIN_LOGIN_PASS = "123";

    public void loginAsSuperAdmin(AdminDatabase adminDatabase) {
        System.out.println("Enter Login ID: ");
        String enteredLoginId = scanner.next();
        if (enteredLoginId.equals(SUPER_ADMIN_LOGIN_ID)) {
            System.out.println("ID is correct");
            System.out.println("Enter the Login Password: ");
            String enteredLoginPassword = readPassword();
            if (enteredLoginPassword.equals(SUPER_ADMIN_LOGIN_PASS)) {
                System.out.println("The password is correct....Entering into SuperAdminPanel");
                SuperAdminFunctions superAdminFunctions = new SuperAdminFunctions();
                superAdminFunctions.welcomeSuperAdmin();
                superAdminFunctions.executeSuperAdminFunction(adminDatabase);
            }
        } 
    }
}
