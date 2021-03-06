package Order;

import Restaurant.FoodTypeEnum;

public class CartItem {
    private String foodName;
    private FoodTypeEnum foodType;
    private double foodCost;
    private boolean veg;
    private int quantity;

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public FoodTypeEnum getFoodType() {
        return this.foodType;
    }

    public void setFoodType(FoodTypeEnum foodType) {
        this.foodType = foodType;
    }

    public double getFoodCost() {
        return this.foodCost;
    }

    public void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public boolean isVeg() {
        return this.veg;
    }

    public void setVeg(boolean veg) {
        this.veg = veg;
    }

    public CartItem(String foodName, FoodTypeEnum foodType, double foodCost, boolean veg, int quantity) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodCost = foodCost;
        this.veg = veg;
        this.quantity = quantity;
    }

    public CartItem() {
        this.foodName = getFoodName();
        this.foodType = getFoodType();
        this.foodCost = getFoodCost();
        this.veg = isVeg();
        this.quantity = getQuantity();
    }

    // To display user information
    @Override
    public String toString() {
        return "\n\tFood Name: " + foodName + "\n"
                + "\tFood Type: " + foodType + "\n"
                + "\tFood Cost: " + foodCost + "\n"
                + "\tIs Veg: " + veg + "\n"
                + "\tQuantity: " + quantity + "\n";
    }

}
