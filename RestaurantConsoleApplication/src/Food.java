public class Food {
    private int foodIdNumber;
    private String foodName;
    private String foodType;
    private double foodCost;
    private boolean veg;

    // Getters Setters for private attributes
	public int getFoodIdNumber() {
		return this.foodIdNumber;
	}
	public void setFoodIdNumber(int foodIdNumber) {
		this.foodIdNumber = foodIdNumber;
	}

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
    Food(int foodIdNumber, String foodName, String foodType, double foodCost, boolean veg) {
        this.foodIdNumber = foodIdNumber;
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodCost = foodCost;
        this.veg = veg;
    }

    Food() {
        this.foodIdNumber = getFoodIdNumber();
        this.foodName = getFoodName();
        this.foodType = getFoodType();
        this.foodCost = getFoodCost();
        this.veg = isVeg();
    }
}
