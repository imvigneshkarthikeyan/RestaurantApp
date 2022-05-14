package Restaurant;
public class Food {
    private String foodName;
    private String foodType;
    private double foodCost;
    private boolean veg;

    // Getters Setters for private attributes
	public String getFoodName() {
		return this.foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return this.foodType;
	}
	public void setFoodType(String foodType) {
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
    public Food(String foodType, double foodCost, boolean veg) {
        this.foodType = foodType;
        this.foodCost = foodCost;
        this.veg = veg;
    }

    public Food() {
        this.foodType = getFoodType();
        this.foodCost = getFoodCost();
        this.veg = isVeg();
    }

    //To display food information
    @Override
    public String toString() {
        return "Food Type: " + foodType
                + " | Food Cost: ₹ " + foodCost
                + " | Is Veg: " + veg;
    }
}
