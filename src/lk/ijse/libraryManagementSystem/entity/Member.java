package lk.ijse.libraryManagementSystem.entity;/*
    @author Dasun
*/

public class Member {

    private String memberID;
    private String memberName;
    private String memberAddress;
    private String memberEmail;
    private String memberNumber;

    public Member(String memberID, String memberName, String memberAddress, String memberEmail, String memberNumber) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberEmail = memberEmail;
        this.memberNumber = memberNumber;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }
}
