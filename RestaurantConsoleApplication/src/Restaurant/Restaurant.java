package Restaurant;
public class Restaurant {
    private String restaurantUniqueNumber;
    private String restaurantName;
    private String restaurantType;
    private String restaurantLocation;
    private String restaurantPhoneNumber;
    private double restaurantAvgCost;
    private String restaurantLoginId;
    private String restaurantLoginPassword;

    //Getters Setters for private attributes
    public String getRestaurantUniqueNumber() {
        return this.restaurantUniqueNumber;
    }

    public void setRestaurantUniqueNumber(String restaurantUniqueNumber) {
        this.restaurantUniqueNumber = restaurantUniqueNumber;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantType() {
        return this.restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    public String getRestaurantLocation() {
        return this.restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public String getRestaurantPhoneNumber() {
        return this.restaurantPhoneNumber;
    }

    public void setRestaurantPhoneNumber(String restaurantPhoneNumber) {
        this.restaurantPhoneNumber = restaurantPhoneNumber;
    }

    public double getRestaurantAvgCost() {
        return this.restaurantAvgCost;
    }

    public void setRestaurantAvgCost(double restaurantAvgCost) {
        this.restaurantAvgCost = restaurantAvgCost;
    }

    public String getrestaurantLoginId() {
        return this.restaurantLoginId;
    }

    public void setrestaurantLoginId(String restaurantLoginId) {
        this.restaurantLoginId = restaurantLoginId;
    }

    public String getrestaurantLoginPassword() {
        return this.restaurantLoginPassword;
    }

    public void setrestaurantLoginPassword(String restaurantLoginPassword) {
        this.restaurantLoginPassword = restaurantLoginPassword;
    }

    //Constructor for Restaurant
    public Restaurant(String restaurantUniqueNumber, String restaurantName, String retaurantType, 
    String restaurantLocation, String retaurantPhoneNumber, double restaurantAvgCost, 
    String restaurantLoginId, String restaurantLoginPassword) {
        this.restaurantUniqueNumber = restaurantUniqueNumber;
        this.restaurantName = restaurantName;
        this.restaurantType = retaurantType;
        this.restaurantLocation = restaurantLocation;
        this.restaurantPhoneNumber = retaurantPhoneNumber;
        this.restaurantAvgCost = restaurantAvgCost;
        this.restaurantLoginId = restaurantLoginId;
        this.restaurantLoginPassword = restaurantLoginPassword;
    }

    public Restaurant() {
        this.restaurantUniqueNumber = getRestaurantUniqueNumber();
        this.restaurantName = getRestaurantName();
        this.restaurantType = getRestaurantType();
        this.restaurantLocation = getRestaurantLocation();
        this.restaurantPhoneNumber = getRestaurantPhoneNumber();
        this.restaurantAvgCost = getRestaurantAvgCost();
        this.restaurantLoginId = getrestaurantLoginId();
        this.restaurantLoginPassword = getrestaurantLoginPassword();
    }

    // To display restaurant information
    @Override
    public String toString() {
        return "Restaurant ID Number: " + restaurantUniqueNumber
                + " | Restaurant Name: " + restaurantName
                + " | Restaurant Type: " + restaurantType
                + " | Restaurant Location: " + restaurantLocation
                + " | Restaurant Conatct: " + restaurantPhoneNumber
                + " | Avg Cost for 2: ₹ " + restaurantAvgCost;
    }
}
