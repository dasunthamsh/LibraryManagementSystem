package lk.ijse.libraryManagementSystem.entity;/*
    @author Dasun
*/

public class Supplier {

    private String supplierID;
    private String suppliersName;
    private String suppliersGmail;
    private String suppliersNo;


    public Supplier(String supplierID, String suppliersName, String suppliersGmail, String suppliersNo) {
        this.supplierID = supplierID;
        this.suppliersName = suppliersName;
        this.suppliersGmail = suppliersGmail;
        this.suppliersNo = suppliersNo;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSuppliersName() {
        return suppliersName;
    }

    public void setSuppliersName(String suppliersName) {
        this.suppliersName = suppliersName;
    }

    public String getSuppliersGmail() {
        return suppliersGmail;
    }

    public void setSuppliersGmail(String suppliersGmail) {
        this.suppliersGmail = suppliersGmail;
    }

    public String getSuppliersNo() {
        return suppliersNo;
    }

    public void setSuppliersNo(String suppliersNo) {
        this.suppliersNo = suppliersNo;
    }
}
