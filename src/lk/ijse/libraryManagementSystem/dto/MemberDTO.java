package lk.ijse.libraryManagementSystem.dto;/*
    @author Dasun
*/

public class MemberDTO {

    private String id;
    private String name;
    private String address;
    private String email;
    private String number;

    public MemberDTO(){

    }

    public MemberDTO(String id, String name, String address, String email, String number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.number = number;
    }

    public MemberDTO(String getNoOfMemeber) {
        this.getNumber();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
