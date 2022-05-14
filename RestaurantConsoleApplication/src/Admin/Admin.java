package Admin;

import User.User;

public class Admin extends User {
    private String adminUniqueId;
    private String adminName;
    private String adminContactNumber;

    //Getters setters for private attributes
    public String getAdminUniqueId() {
        return this.adminUniqueId;
    }

    public void setAdminUniqueId(String adminUniqueId) {
        this.adminUniqueId = adminUniqueId;
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
    public Admin(String adminUniqueId, String adminName, String adminContactNumber, String adminLoginPassword) {
        super(adminLoginPassword);
        this.adminUniqueId = adminUniqueId;
        this.adminName = adminName;
        this.adminContactNumber = adminContactNumber;
    }

    public Admin() {
        this.adminUniqueId = getAdminUniqueId();
        this.adminName = getAdminName();
        this.adminContactNumber = getAdminContactNumber();
    }

    //To display admin information
    @Override
    public String toString() {
        return "Admin Unique ID: " + adminUniqueId 
                + " | Admin Name: " + adminName
                + " | Admin Ph Num: " + adminContactNumber;
    }
}
