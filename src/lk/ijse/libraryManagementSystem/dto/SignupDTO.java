package lk.ijse.libraryManagementSystem.dto;/*
    @author Dasun
*/

public class SignupDTO {

    private String Lid;
    private String Lname;
    private String Lusername;
    private String LPassword;


    public SignupDTO(String lid, String lname, String lusername, String LPassword) {
        this.Lid = lid;
        this.Lname = lname;
       this.Lusername = lusername;
        this.LPassword = LPassword;
    }


    public SignupDTO(String lid, String password) {
        this.Lid = lid;
        this.LPassword = password;
    }

    public String getLid() {
        return Lid;
    }

    public void setLid(String lid) {
        Lid = lid;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getLusername() {
        return Lusername;
    }

    public void setLusername(String lusername) {
        Lusername = lusername;
    }

    public String getLPassword() {
        return LPassword;
    }

    public void setLPassword(String LPassword) {
        this.LPassword = LPassword;
    }
}
