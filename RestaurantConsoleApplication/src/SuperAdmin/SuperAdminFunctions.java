package SuperAdmin;
import Utilities.Operations;
import Admin.Admin;
import Admin.AdminDatabase;
import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class SuperAdminFunctions implements Operations {


    @Override
    public void viewData() {
        // View Admins available from admin map
        AdminDatabase adminDatabase = new AdminDatabase();
        adminDatabase.printAdminData();
        
    }

    @Override
    public void addData() {
        // Add new admin to admin map
        AdminDatabase adminDatabase = new AdminDatabase();
        // adminDatabase.getAdminMap().put(key, new Admin(adminName, adminContactNumber, adminLoginPassword));
    }

    @Override
    public void deleteData() {
        // Delete admin from admin map
        AdminDatabase adminDatabase = new AdminDatabase();
        // adminDatabase.getAdminMap().remove(key);
        
    }
    
}
