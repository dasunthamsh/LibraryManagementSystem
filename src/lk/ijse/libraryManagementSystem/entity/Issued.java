package lk.ijse.libraryManagementSystem.entity;/*
    @author Dasun
*/

public class Issued {
    private String bookID;
    private String memberID;
    private String bookAvalability;
    private String duedate;
    private String time;
    private String date;


    public Issued(String memberID,String bookID, String time,String date, String duedate, String bookAvalability) {
        this.memberID = memberID;
        this.bookID = bookID;
        this.time = time;
        this.date = date;
        this.duedate = duedate;
        this.bookAvalability = bookAvalability;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getBookAvalability() {
        return bookAvalability;
    }

    public void setBookAvalability(String bookAvalability) {
        this.bookAvalability = bookAvalability;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
