package lk.ijse.libraryManagementSystem.dto;/*
    @author Dasun
*/

public class SupplyerDTO {

    private String sId;
    private String sName;
    private String sEmail;
    private String sNo;

    public SupplyerDTO(String sId, String sName, String sEmail, String sNo) {
        this.sId = sId;
        this.sName = sName;
        this.sEmail = sEmail;
        this.sNo = sNo;
    }
    public SupplyerDTO(){

    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }
}
