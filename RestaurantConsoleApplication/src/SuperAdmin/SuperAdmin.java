package SuperAdmin;
import static Utilities.ValidatorUtils.*;

import User.User;


public class SuperAdmin extends User {
    private final String SUPER_ADMIN_LOGIN_ID = "superadmin@abc.com";
    private final String SUPER_ADMIN_LOGIN_PASS = "123";

    @Override
    public void setLoginID(String loginID) {
        super.setLoginID(SUPER_ADMIN_LOGIN_ID);
    }

    @Override
    public void setLoginPassword(String loginPassword) {
        super.setLoginPassword(SUPER_ADMIN_LOGIN_PASS);
    }

    public void loginAsSuperAdmin() {
        System.out.println("Enter Login ID: ");
        String enteredLoginId = scanner.next();
        if (enteredLoginId.equals(getLoginID())) {
            System.out.println("ID is correct");
            System.out.println("Enter the Login Password: ");
            String enteredLoginPassword = readPassword();
            if (enteredLoginPassword.equals(getLoginPassword())) {
                System.out.println("The password is correct....Entering into SuperAdminPanel");
            } else {
                System.out.println("Login password is wrong");
            }
        } else {
            System.out.println("Login ID is wrong");
        }
    }
}
