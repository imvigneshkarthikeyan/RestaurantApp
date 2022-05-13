package Admin;
public class Admin {
    private String adminUniqueId;
    private String adminName;
    private String adminContactNumber;
    private String adminLoginId;
    private String adminLoginPassword;

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

    public String getAdminLoginId() {
        return this.adminLoginId;
    }

    public void setAdminLoginId(String adminLoginId) {
        this.adminLoginId = adminLoginId;
    }

    public String getAdminLoginPassword() {
        return this.adminLoginPassword;
    }

    public void setAdminLoginPassword(String adminLoginPassword) {
        this.adminLoginPassword = adminLoginPassword;
    }

    //Constructor for Admin
    public Admin(String adminUniqueId, String adminName, String adminContactNumber, String adminLoginPassword) {
        this.adminUniqueId = adminUniqueId;
        this.adminName = adminName;
        this.adminContactNumber = adminContactNumber;
        this.adminLoginPassword = adminLoginPassword;
    }

    public Admin() {
        this.adminUniqueId = getAdminUniqueId();
        this.adminName = getAdminName();
        this.adminContactNumber = getAdminContactNumber();
        this.adminLoginPassword = getAdminLoginPassword();
    }

    //To display admin information
    @Override
    public String toString() {
        return "Admin Unique ID: " + adminUniqueId 
                + " | Admin Name: " + adminName
                + " | Admin Ph Num: " + adminContactNumber;
    }
}
