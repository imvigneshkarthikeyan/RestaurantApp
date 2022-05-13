public class User implements DisplayInformation {
    private String uniqueUserId;
    private String nameOfuser;
    private String phoneNumberOfUser;
    private String userLoginId;
    private String userLoginPassword;
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

    public String getUserLoginId() {
        return this.userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserLoginPassword() {
        return this.userLoginPassword;
    }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    public boolean isPremiumUser() {
        return this.premiumUser;
    }

    public void setPremiumUser(boolean premiumUser) {
        this.premiumUser = premiumUser;
    }

    //Constructor for user
    public User(String uniqueUserId, String nameOfUser, String phoneNumberofUser, String userLoginId, 
    String userLoginPassword, boolean premiumUser) {
        this.uniqueUserId = uniqueUserId;
        this.nameOfuser = nameOfUser;
        this.phoneNumberOfUser = phoneNumberofUser;
        this.userLoginId = userLoginId;
        this.userLoginPassword = userLoginPassword;
        this.premiumUser = premiumUser;
    }

    public User() {
        this.uniqueUserId = getUniqueUserId();
        this.nameOfuser = getNameOfuser();
        this.phoneNumberOfUser = getPhoneNumberOfUser();
        this.userLoginId = getUserLoginId();
        this.userLoginPassword = getUserLoginPassword();
        this.premiumUser = isPremiumUser();
    }

    @Override
    public void displayInfo() {
        System.out.println("User ID Number: " + uniqueUserId
                        + " | User Name: " + nameOfuser
                        + " | User Ph No: " + phoneNumberOfUser
                        + " | Premium User: " + premiumUser);
    }

}
