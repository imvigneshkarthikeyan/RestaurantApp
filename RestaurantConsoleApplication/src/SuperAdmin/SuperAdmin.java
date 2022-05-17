package SuperAdmin;
import static Utilities.ValidatorUtils.*;
import static Utilities.UiUtils.*;
import Admin.AdminDatabase;

public class SuperAdmin {
    private final String SUPER_ADMIN_LOGIN_ID = "superadmin@abc.com";
    private final String SUPER_ADMIN_LOGIN_PASS = "123";

    public void loginAsSuperAdmin(AdminDatabase adminDatabase) {
        int option = 1;
        scanner.nextLine();
        while (option == 1) {
            System.out.println("Enter Login ID: ");
            String enteredLoginId = scanner.nextLine();
            if (enteredLoginId.equals(SUPER_ADMIN_LOGIN_ID)==false) {
                drawDoubleLine();
                System.out.println("Login ID is wrong\nEnter 1: To try again\nEnter 2: Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("ID is correct");
                drawLine();                
                validatePassword(adminDatabase);
                option = 2;
            }
        }
    }

    private void validatePassword(AdminDatabase adminDatabase) {
        int option = 1;
        while (option == 1) {
            drawDoubleLine();
            System.out.println("Enter the Login Password: ");
            String enteredLoginPassword = readPassword();
            if (enteredLoginPassword.equals(SUPER_ADMIN_LOGIN_PASS) == false) {
                System.out.println("Password is wrong\nEnter 1: To try again\nEnter 2: Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                drawLine();
                System.out.println("The password is correct....Entering into SuperAdminPanel");
                SuperAdminFunctions superAdminFunctions = new SuperAdminFunctions();
                superAdminFunctions.welcomeSuperAdmin();
                superAdminFunctions.executeSuperAdminFunction(adminDatabase);
                option = 2;
            }
        }
        drawDoubleLine();
    }
}
