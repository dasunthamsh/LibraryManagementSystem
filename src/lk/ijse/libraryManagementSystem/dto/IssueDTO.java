package lk.ijse.libraryManagementSystem.dto;/*
    @author Dasun
*/

public class IssueDTO {
    private String bId;
    private String mId;
    private String avalability;
    private String dueDate;
    private String dueTime;
    private String localDate;

    public IssueDTO(String bId, String mId, String dueDate, String dueTime, String localDate, String avalability) {
        this.bId = bId;
        this.mId = mId;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.localDate = localDate;
        this.avalability = avalability;
    }


    public IssueDTO(String bId, String avalability){
        this.avalability = avalability;
        this.bId=bId;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getAvalability() {
        return avalability;
    }
    public void setAvalability(String avalability) {
        this.avalability = avalability;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }
}
