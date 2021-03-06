package Restaurant;

import User.User;

public class Restaurant extends User {
    private String restaurantName;
    private RestaurantTypeEnum restaurantType;
    private String restaurantLocation;
    private String restaurantPhoneNumber;
    private double restaurantAvgCost;

    //Getters Setters for private attributes
    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public RestaurantTypeEnum getRestaurantType() {
        return this.restaurantType;
    }

    public void setRestaurantType(RestaurantTypeEnum restaurantType) {
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

    @Override
    public void setLoginID(String loginID) {
        super.setLoginID(loginID);
    }
    @Override
    public String getLoginID() {
        return super.getLoginID();
    }

    @Override
    public void setLoginPassword(String loginPassword) {
        super.setLoginPassword(loginPassword);
    }
    @Override
    public String getLoginPassword() {
        return super.getLoginPassword();
    }


    //Constructor for Restaurant
    public Restaurant(String restaurantName, 
            RestaurantTypeEnum retaurantType, 
    String restaurantLocation, String retaurantPhoneNumber, double restaurantAvgCost, 
    String restaurantLoginId, String restaurantLoginPassword) {
        super(restaurantLoginId, restaurantLoginPassword);
        this.restaurantName = restaurantName;
        this.restaurantType = retaurantType;
        this.restaurantLocation = restaurantLocation;
        this.restaurantPhoneNumber = retaurantPhoneNumber;
        this.restaurantAvgCost = restaurantAvgCost;
    }

    public Restaurant() {
        this.restaurantName = getRestaurantName();
        this.restaurantType = getRestaurantType();
        this.restaurantLocation = getRestaurantLocation();
        this.restaurantPhoneNumber = getRestaurantPhoneNumber();
        this.restaurantAvgCost = getRestaurantAvgCost();
    }

    // To display restaurant information
    @Override
    public String toString() {
        return "\nRestaurant Name: " + restaurantName + "\n"
                + "Restaurant Type: " + restaurantType + "\n"
                + "Restaurant Location: " + restaurantLocation + "\n"
                + "Restaurant Conatct: " + restaurantPhoneNumber + "\n"
                + "Avg Cost for 2: ??? " + restaurantAvgCost + "\n";
    }
}
