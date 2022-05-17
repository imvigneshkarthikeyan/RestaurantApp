package SuperAdmin;
import Admin.Admin;
import Admin.AdminDatabase;
import static Utilities.UiUtils.*;
import static Utilities.ValidatorUtils.*;

public class SuperAdminFunctions {

    public void viewData(AdminDatabase adminDatabase) {
        if (adminDatabase.getAdminMap().isEmpty()) {
            System.out.println("No Admins added till now");
        } else {
            // View Admins available from admin map
            adminDatabase.printAdminData();
        }
        drawDoubleLine();       
    }

    
    public void addData(AdminDatabase adminDatabase) {
        scanner.nextLine();
        // Add new admin to admin map
        Admin admin = new Admin();
        drawDoubleLine();
        int option = 1;
        while (option == 1) {
            System.out.println("Set new admin login id: ");
            admin.setLoginID(scanner.nextLine());
            if (adminDatabase.getAdminMap().containsKey(admin.getLoginID())) {
                System.out.println("This admin already exists, \nEnter 1: To Try again and create different ID \nEnter 2: To Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                drawLine();
                System.out.println("Set new admin name: ");
                admin.setAdminName(scanner.nextLine());
                drawLine();
                System.out.println("Set new admin contact number: ");
                admin.setAdminContactNumber(scanner.nextLine());
                drawLine();
                System.out.println("Set new password: ");
                admin.setLoginPassword(scanner.nextLine());
                drawDoubleLine();
                adminDatabase.getAdminMap().put(admin.getLoginID(),
                        new Admin(admin.getAdminName(), admin.getAdminContactNumber(), admin.getLoginPassword()));
                System.out.println("Admin with: " + admin.getLoginID() + " was added to database.");
                System.out.println("The admin DB after adding: ");
                adminDatabase.printAdminData();
                drawDoubleLine();
                option = 2;
            }
            drawDoubleLine();
        }
    }

    
    public void deleteData(AdminDatabase adminDatabase) {
        scanner.nextLine();
        // Delete admin from admin map
        int option = 1;
        while (option == 1) {
            System.out.println("Enter the login id of the admin that has to be removed: ");
            String adminToBeRemoved = scanner.nextLine();
            if (adminDatabase.getAdminMap().containsKey(adminToBeRemoved) == false) {
                System.out.println("There is no such login ID\nEnter 1: To try again\nEnter 2: To Go Back");
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                adminDatabase.getAdminMap().remove(adminToBeRemoved);
                System.out.println("The admin with login ID: " + adminToBeRemoved + " was removed successfully!");
                drawDoubleLine();
                System.out.println("The admin DB after deleting: ");
                adminDatabase.printAdminData();
                option = 2;
            }
        }   
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
                    break;
                default:
                    break;
            }
        }
    }
}
