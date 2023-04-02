package lk.ijse.libraryManagementSystem.entity;/*
    @author Dasun
*/

public class ReturnBook {
        private String bookID;
        private String memberID;
        private int bookAvalability;
        private String returnDate;
        private String dueDate;


    public ReturnBook(String bookID, String memberID, String returnDate, String dueDate, int bookAvalability) {
        this.bookID = bookID;
        this.memberID = memberID;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
        this.bookAvalability = bookAvalability;

    }

    public ReturnBook(String bookID, int bookAvalability) {
        this.bookID = bookID;
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

    public int getBookAvalability() {
        return bookAvalability;
    }

    public void setBookAvalability(int bookAvalability) {
        this.bookAvalability = bookAvalability;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
