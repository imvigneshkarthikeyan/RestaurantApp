import Admin.AdminDatabase;
import Admin.AdminAuthenticator;
import Food.FoodDatabase;
import Food.FoodSearch;
import User.UserAuthenticator;
import User.UserDatabase;


public class Main {
    public static void main(String[] args) throws Exception {
        // drawDoubleLine();
        // SuperAdmin superAdmin = new SuperAdmin();
        UserDatabase userDatabase = new UserDatabase();
        UserAuthenticator userAuthenticator = new UserAuthenticator();
        AdminDatabase adminDatabase = new AdminDatabase();
        AdminAuthenticator authenticateAdmin = new AdminAuthenticator();
        FoodDatabase foodDatabase = new FoodDatabase();
        FoodSearch foodSearch = new FoodSearch();
        userDatabase.addUserData();
        userDatabase.printUserData();
        userAuthenticator.authenticateUser(userDatabase);
        foodDatabase.addFoodData();
        foodDatabase.printFoodData();
        foodSearch.searchFood(foodDatabase);
        adminDatabase.addAdminData();
        adminDatabase.printAdminData();
        authenticateAdmin.authenticateAdmin(adminDatabase);
        
    }
}
