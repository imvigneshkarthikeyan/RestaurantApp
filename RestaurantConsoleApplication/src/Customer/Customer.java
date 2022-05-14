package Customer;
import User.User;

public class Customer extends User {
    private String uniqueUserId;
    private String nameOfuser;
    private String phoneNumberOfUser;
    private boolean premiumUser;

    //Getters setters for private attributes
    public String getUniqueUserId() {
        return this.uniqueUserId;
    }

    public void setUniqueUserId(String uniqueUserId) {
        this.uniqueUserId = uniqueUserId;
    }

    public String getNameOfuser() {
        return this.nameOfuser;
    }

    public void setNameOfuser(String nameOfuser) {
        this.nameOfuser = nameOfuser;
    }

    public String getPhoneNumberOfUser() {
        return this.phoneNumberOfUser;
    }

    public void setPhoneNumberOfUser(String phoneNumberOfUser) {
        this.phoneNumberOfUser = phoneNumberOfUser;
    }

    public boolean isPremiumUser() {
        return this.premiumUser;
    }

    public void setPremiumUser(boolean premiumUser) {
        this.premiumUser = premiumUser;
    }

    //Constructor for user
    public Customer(String uniqueUserId, String nameOfUser, String phoneNumberofUser, 
    String userLoginPassword, boolean premiumUser) {
        super(userLoginPassword);
        this.uniqueUserId = uniqueUserId;
        this.nameOfuser = nameOfUser;
        this.phoneNumberOfUser = phoneNumberofUser;
        this.premiumUser = premiumUser;
    }

    public Customer() {
        this.uniqueUserId = getUniqueUserId();
        this.nameOfuser = getNameOfuser();
        this.phoneNumberOfUser = getPhoneNumberOfUser();
        this.premiumUser = isPremiumUser();
    }

    // To display user information
    @Override
    public String toString() {
        return "User ID Number: " + uniqueUserId
                + " | User Name: " + nameOfuser
                + " | User Ph No: " + phoneNumberOfUser
                + " | Premium User: " + premiumUser;
    }

}
