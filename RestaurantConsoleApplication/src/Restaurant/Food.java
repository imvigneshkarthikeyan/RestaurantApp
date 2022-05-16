package Restaurant;
public class Food {
    private String foodName;
    private FoodTypeEnum foodType;
    private double foodCost;
    private boolean veg;

    // Getters Setters for private attributes
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

    //Constructor for Food
    public Food(String foodName, FoodTypeEnum foodType, double foodCost, boolean veg) {
		this.foodName = foodName;
        this.foodType = foodType;
        this.foodCost = foodCost;
        this.veg = veg;
    }

    public Food() {
		this.foodName = getFoodName();
        this.foodType = getFoodType();
        this.foodCost = getFoodCost();
        this.veg = isVeg();
    }

    //To display food information
    @Override
    public String toString() {
        return "Food Name: " + foodName
				+ " | Food Type: " + foodType
                + " | Food Cost: ₹ " + foodCost
                + " | Is Veg: " + veg;
    }
}
