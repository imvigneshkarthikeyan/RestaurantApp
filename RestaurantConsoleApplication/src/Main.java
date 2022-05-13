import Admin.AdminDatabase;
import Admin.AuthenticateAdmin;
import Food.FoodDatabase;
import Food.FoodSearch;


public class Main {
    public static void main(String[] args) throws Exception {
        // drawDoubleLine();
        // SuperAdmin superAdmin = new SuperAdmin();
        AdminDatabase adminDatabase = new AdminDatabase();
        AuthenticateAdmin authenticateAdmin = new AuthenticateAdmin();
        FoodDatabase foodDatabase = new FoodDatabase();
        FoodSearch foodSearch = new FoodSearch();
        foodDatabase.addFoodData();
        foodDatabase.printFoodData();
        foodSearch.searchFood(foodDatabase);
        adminDatabase.addAdminData();
        adminDatabase.printAdminData();
        authenticateAdmin.authenticateAdmin(adminDatabase);
        
    }
}
