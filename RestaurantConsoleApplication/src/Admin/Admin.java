package Admin;

import User.User;

public class Admin extends User {
    private String adminName;
    private String adminContactNumber;

    //Getters setters for private attributes
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

    public String getAdminName() {
        return this.adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminContactNumber() {
        return this.adminContactNumber;
    }

    public void setAdminContactNumber(String adminContactNumber) {
        this.adminContactNumber = adminContactNumber;
    }

    //Constructor for Admin
    public Admin(String adminName, String adminContactNumber, String adminLoginPassword) {
        super(adminLoginPassword);
        this.adminName = adminName;
        this.adminContactNumber = adminContactNumber;
    }

    public Admin() {
        this.adminName = getAdminName();
        this.adminContactNumber = getAdminContactNumber();
    }

    //To display admin information
    @Override
    public String toString() {
        return "Admin Name: " + adminName
            + " | Admin Ph Num: " + adminContactNumber + "\n";
    }
}
