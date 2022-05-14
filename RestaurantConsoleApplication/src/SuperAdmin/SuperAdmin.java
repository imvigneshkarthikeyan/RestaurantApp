package SuperAdmin;
import static Utilities.ValidatorUtils.*;

public class SuperAdmin {
    private final String SUPER_ADMIN_LOGIN_ID = "superadmin@abc.com";
    private final String SUPER_ADMIN_LOGIN_PASS = "123";

    public String getSuperAdminLogin() {
		return SUPER_ADMIN_LOGIN_ID;
	}

    public String getSuperAdminPassword() {
		return SUPER_ADMIN_LOGIN_PASS;
	}

    public void loginAsSuperAdmin() {
        System.out.println("Enter Login ID: ");
        String enteredLoginId = scanner.next();
        if (enteredLoginId.equals(SUPER_ADMIN_LOGIN_ID)) {
            System.out.println("ID is correct");
            System.out.println("Enter the Login Password: ");
            String enteredLoginPassword = readPassword();
            if (enteredLoginPassword.equals(SUPER_ADMIN_LOGIN_PASS)) {
                System.out.println("The password is correct....Entering into SuperAdminPanel");
            } else {
                System.out.println("Login password is wrong");
            }
        } else {
            System.out.println("Login ID is wrong");
        }
    }
}
