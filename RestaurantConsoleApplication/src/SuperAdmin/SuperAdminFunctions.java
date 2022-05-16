package SuperAdmin;
import Admin.Admin;
import Admin.AdminDatabase;
import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class SuperAdminFunctions {

    public void viewData(AdminDatabase adminDatabase) {
        // View Admins available from admin map
        adminDatabase.printAdminData(); 
        drawDoubleLine();       
    }

    
    public void addData(AdminDatabase adminDatabase) {
        // Add new admin to admin map
        Admin admin = new Admin();
        drawDoubleLine();
        System.out.println("Set new admin login id: ");
        admin.setLoginID(scanner.next());
        drawLine();
        System.out.println("Set new admin name: ");
        admin.setAdminName(scanner.next());
        drawLine();
        System.out.println("Set new admin contact number: ");
        admin.setAdminContactNumber(scanner.next());
        drawLine();
        System.out.println("Set new password: ");
        admin.setLoginPassword(scanner.next());
        drawDoubleLine();
        adminDatabase.getAdminMap().put(admin.getLoginID(), new Admin(admin.getAdminName(), admin.getAdminContactNumber(), admin.getLoginPassword()));
        System.out.println("Admin with: " + admin.getLoginID() + " was added to database.");
        System.out.println("The admin DB after adding: ");
        adminDatabase.printAdminData();
        drawDoubleLine();
    }

    
    public void deleteData(AdminDatabase adminDatabase) {
        // Delete admin from admin map
        System.out.println("Enter the login id of the admin that has to be removed: ");
        adminDatabase.getAdminMap().remove(scanner.next());
        System.out.println("The admin DB after deleting: ");
        adminDatabase.printAdminData();    
        drawDoubleLine();    
    }

    public void welcomeSuperAdmin() {
        displayLineTitleAndUser("Welcome", "Super Admin");
    }

    public void displayOptionsForSuperAdmin() {
        System.out.println("Enter the option: \n1. View All Admins \n2. Add new Admin \n3. Delete an admin \n4. Logout");
        drawLine();
    }
    
    public void executeSuperAdminFunction(AdminDatabase adminDatabase) {
        int option = 1;
        while (option == 1 || option == 2 || option == 3) {
            displayOptionsForSuperAdmin();
            option = scanner.nextInt();
            optionValidator(option, 1, 4);
            switch (option) {
                case 1:
                    viewData(adminDatabase);
                    break;
                case 2:
                    addData(adminDatabase);
                    break;
                case 3:
                    deleteData(adminDatabase);
                    break;
                case 4:
                    drawLine();
                    System.out.println("Logging out from Super admin portal");
                default:
                    break;
            }
        }
    }
}
