package lk.ijse.libraryManagementSystem.entity;/*
    @author Dasun
*/

public class Book {
    private String bookID;
    private String bookAvalability;
    private String bookName;
    private String bookAuthor;
    private String bookCategorie;
    private String bookRackNo;
    private String qyt;
    private String bookAddedTime;
    private String supplierID;

    public Book(String bookID, String bookAvalability, String bookName, String bookAuthor, String bookCategorie, String bookRackNo, String qyt, String bookAddedTime) {
        this.bookID = bookID;
        this.bookAvalability = bookAvalability;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCategorie = bookCategorie;
        this.bookRackNo = bookRackNo;
        this.qyt = qyt;
        this.bookAddedTime = bookAddedTime;
    }

    public Book(String bookID, String bookAddedTime) {
        this.bookID = bookID;
        this.bookAddedTime = bookAddedTime;
    }

    public Book( String bookAddedTime, String bookID,String supplierID) {
        this.bookAddedTime = bookAddedTime;
        this.bookID = bookID;
        this.supplierID = supplierID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookAvalability() {
        return bookAvalability;
    }

    public void setBookAvalability(String bookAvalability) {
        this.bookAvalability = bookAvalability;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategorie() {
        return bookCategorie;
    }

    public void setBookCategorie(String bookCategorie) {
        this.bookCategorie = bookCategorie;
    }

    public String getBookRackNo() {
        return bookRackNo;
    }

    public void setBookRackNo(String bookRackNo) {
        this.bookRackNo = bookRackNo;
    }

    public String getQyt() {
        return qyt;
    }

    public void setQyt(String qyt) {
        this.qyt = qyt;
    }

    public String getBookAddedTime() {
        return bookAddedTime;
    }

    public void setBookAddedTime(String bookAddedTime) {
        this.bookAddedTime = bookAddedTime;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }
}
