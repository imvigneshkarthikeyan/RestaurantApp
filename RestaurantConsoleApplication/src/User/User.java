package User;
public class User {
    private String loginID;
    private String loginPassword;

    public String getLoginID() {
        return this.loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public User(String loginID, String loginPassword) {
        this.loginID = loginID;
        this.loginPassword = loginPassword;
    }

    public User(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public User() {
        this.loginID = getLoginID();
        this.loginPassword = getLoginPassword();
    }

}
