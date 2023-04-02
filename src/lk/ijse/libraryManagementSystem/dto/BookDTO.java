package lk.ijse.libraryManagementSystem.dto;/*
    @author Dasun
*/

public class BookDTO {
    private String bId;
    private String avalability;
    private String bName;
    private String bAuthor;
    private String bCategory;
    private String bRackNo;
    private String bQyt;
    private String bAddTime;
    private String sId;


    public BookDTO(String bId, String avalability, String bName, String bAuthor, String bCategory, String bRackNo, String bQyt, String bAddTime, String sId) {
        this.bId = bId;
        this.avalability = avalability;
        this.bName = bName;
        this.bAuthor = bAuthor;
        this.bCategory = bCategory;
        this.bRackNo = bRackNo;
        this.bQyt = bQyt;
        this.bAddTime = bAddTime;
        this.sId = sId;
    }

    public BookDTO(String bAddTime, String bId, String sId){
        this.bAddTime=bAddTime;
        this.bId=bId;
        this.sId=sId;

    }

    public BookDTO(String bAddTime, String bId){
        this.bAddTime=bAddTime;
        this.bId=bId;

    }



    public BookDTO(String bId, String avalability, String bName, String bAuthor, String bCategory, String bRackNo, String bQyt, String bAddTime) {
        this.bId = bId;
        this. avalability = avalability;
        this.bName = bName;
        this.bAuthor = bAuthor;
        this.bCategory = bCategory;
        this.bRackNo = bRackNo;
        this.bQyt = bQyt;
        this.bAddTime = bAddTime;

    }

    public BookDTO(String bId, String bAvalability, String bName, String bAuthor, String bCategory, String bRackNo, String bQyt){

    }




    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getbAvalability() {
        return avalability;
    }

    public void setbAvalability(String bAvalability) {
        this.avalability = bAvalability;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getbCategory() {
        return bCategory;
    }

    public void setbCategory(String bCategory) {
        this.bCategory = bCategory;
    }

    public String getbRackNo() {
        return bRackNo;
    }

    public void setbRackNo(String bRackNo) {
        this.bRackNo = bRackNo;
    }

    public String getbQyt() {
        return bQyt;
    }

    public void setbQyt(String bQyt) {
        this.bQyt = bQyt;
    }

    public String getbAddTime() {
        return bAddTime;
    }

    public void setbAddTime(String bAddTime) {
        this.bAddTime = bAddTime;
    }


    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }
}
