public class Food implements DisplayInformation {
    private int foodUniqueNumber;
    private String foodName;
    private String foodType;
    private double foodCost;
    private boolean veg;

    // Getters Setters for private attributes
	public int getFoodIdNumber() {
		return this.foodUniqueNumber;
	}
	public void setFoodIdNumber(int foodUniqueNumber) {
		this.foodUniqueNumber = foodUniqueNumber;
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
    public Food(int foodUniqueNumber, String foodName, String foodType, double foodCost, boolean veg) {
        this.foodUniqueNumber = foodUniqueNumber;
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodCost = foodCost;
        this.veg = veg;
    }

    public Food() {
        this.foodUniqueNumber = getFoodIdNumber();
        this.foodName = getFoodName();
        this.foodType = getFoodType();
        this.foodCost = getFoodCost();
        this.veg = isVeg();
    }

    //To display food information
    @Override
    public void displayInfo() {
        System.out.println("Food ID: " + foodUniqueNumber 
                    + " | Food Name: " + foodName
                    + " | Food Type: " + foodType
                    + " | Food Cost: ₹ " + foodCost
                    + " | Is Veg: " + veg);        
    }
}
