package lk.ijse.libraryManagementSystem.entity;/*
    @author Dasun
*/

import rex.utils.S;

public class Login {

    private String lbrarianID;
    private String loginName;
    private String loginUsername;
    private String loginPassword;

    public String getLbrarianID() {
        return lbrarianID;
    }

    public void setLbrarianID(String lbrarianID) {
        this.lbrarianID = lbrarianID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
