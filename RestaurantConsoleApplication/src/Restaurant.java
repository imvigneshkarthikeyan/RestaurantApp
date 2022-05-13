public class Restaurant implements DisplayInformation {
    private int restaurantUniqueNumber;
    private String restaurantName;
    private String restaurantLoginId;
    private String restaurantLoginPassword;

    //Getters Setters for private attributes
    public int getRestaurantUniqueNumber() {
        return this.restaurantUniqueNumber;
    }

    public void setRestaurantUniqueNumber(int restaurantUniqueNumber) {
        this.restaurantUniqueNumber = restaurantUniqueNumber;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
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
    public Restaurant(int restaurantUniqueNumber, String restaurantName, String restaurantLoginId, String restaurantLoginPassword) {
        this.restaurantUniqueNumber = restaurantUniqueNumber;
        this.restaurantName = restaurantName;
        this.restaurantLoginId = restaurantLoginId;
        this.restaurantLoginPassword = restaurantLoginPassword;
    }

    public Restaurant() {
        this.restaurantUniqueNumber = getRestaurantUniqueNumber();
        this.restaurantName = getRestaurantName();
        this.restaurantLoginId = getrestaurantLoginId();
        this.restaurantLoginPassword = getrestaurantLoginPassword();
    }

    //To display restaurant information
    @Override
    public void displayInfo() {
        System.out.println("Restaurant ID Number: " + restaurantUniqueNumber
                        + " | Restaurant Name: " + restaurantName);
    }

}
