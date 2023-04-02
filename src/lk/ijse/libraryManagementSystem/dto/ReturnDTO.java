package lk.ijse.libraryManagementSystem.dto;/*
    @author Dasun
*/

public class ReturnDTO {
    private String bId;
    private String mId;
    private int avalability;
    private String returnTime;
    private String fine;
    private String bookdueDate;

    public ReturnDTO(String mId, String bId, String returnTime, String bookdueDate, int avalability) {
        this.mId = mId;
        this.bId = bId;
        this.returnTime = returnTime;
        this.bookdueDate = bookdueDate;
        this.avalability = avalability;
    }

        public ReturnDTO(String bId, String mId, int avalability){

        this.bId=bId;
        this.avalability= avalability;
        this.mId=mId;

    }
//
//    public ReturnDTO( String mId){
//        this.mId=mId;
//
//    }

    public ReturnDTO(String mId, String bId, String returnTime, String fine, String bookdueDate, int avalability) {
        this.bId = bId;
        this.mId = mId;
        this.returnTime = returnTime;
        this.fine = fine;
        this.bookdueDate = bookdueDate;
        this.avalability = avalability;
    }

//    public ReturnDTO(String mId, String bId,String avalability , String bookdueDate) {
//        this.mId = mId;
//        this.bId = bId;
//        this.avalability=avalability;
//        this.bookdueDate = bookdueDate;
//    }

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

    public int getAvalability() {
        return avalability;
    }

    public void setAvalability(int avalability) {
        this.avalability = avalability;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }



    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getBookdueDate() {
        return bookdueDate;
    }

    public void setBookdueDate(String bookdueDate) {
        this.bookdueDate = bookdueDate;
    }
}
