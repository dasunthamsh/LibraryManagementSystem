package lk.ijse.libraryManagementSystem.controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lk.ijse.libraryManagementSystem.bo.BookBO;
import lk.ijse.libraryManagementSystem.bo.SupplierDetailsTrBO;
import lk.ijse.libraryManagementSystem.bo.SupplyerBO;
import lk.ijse.libraryManagementSystem.bo.impl.BookBOImpl;
import lk.ijse.libraryManagementSystem.bo.impl.SupplierDetailsTrBOImpl;
import lk.ijse.libraryManagementSystem.dao.impl.BookDAOImpl;
import lk.ijse.libraryManagementSystem.dao.impl.SupplierDetailDAOImpl;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.SupplyerDTO;
import lk.ijse.libraryManagementSystem.util.BOFactory;
import rex.utils.S;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddBookFormController implements Initializable {
    public JFXTextField txtBookCategory;
    public JFXTextField txtBookAuthor;
    public JFXTextField txtBookAvalability;
    public JFXTextField txtBookName;
    public JFXTextField txtBookId;
    public JFXTextField txtRackNo;
    public JFXTextField txtBookQyt;
    public TableColumn tblBookId;
    public TableColumn tblName;
    public TableColumn tblCategory;
    public TableColumn tblAuthor;
    public TableColumn tblAvailability;
    public TableColumn tblRackNo;
    public TableColumn tblqyt;
    public ComboBox comBookSupplyerId;
    public TableView tblAddBook;
    public Label txtDate;
    public ComboBox cmbBookAvalability;
    public JFXTextField txtTimeAddBook;
    public TableColumn tblTime;

    BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);
    SupplyerBO supplyerBO = (SupplyerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLYER);
    SupplierDetailsTrBO supplierDetailsTrBO = (SupplierDetailsTrBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SuppliyerDetailsTr);

    public void lodeNextBookId(){  // lode next book id
        try {
            BookBO bookBO = new BookBOImpl();
            String id = bookBO.getLastBookId();
            txtBookId.setText(id);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        lodeSupplierIds();
        avalableBook();
        bookAddTime();
        lodeNextBookId();





    }
    public void bookAddTime(){
        LocalDate date = LocalDate.now();
        txtTimeAddBook.setText(String.valueOf(date));
    }

    private void lodeSupplierIds(){ // book ids lode dto combo box
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = BookDAOImpl.lodeSupplierId();

            for(String id : idList){
                observableList.add(id);
            }
            comBookSupplyerId.setItems(observableList);
        }catch (Exception ex){

        }
    }

    private  void avalableBook(){   // avalabale books (yes / no)

            ObservableList<String> list = FXCollections.observableArrayList();
            list.addAll("Sinhala" ,"English" ,"Tamil","French");
            cmbBookAvalability.setItems(list);
    }



    public void btnAddOnAction(ActionEvent actionEvent){ //  Add books
        try {
            String bId = txtBookId.getText();
            String bAvalability = String.valueOf(cmbBookAvalability.getValue());
            String bName = txtBookName.getText();
            String bAuthor = txtBookAuthor.getText();
            String bCategory = txtBookCategory.getText();
            String bRackNo = txtRackNo.getText();
            String bQyt = txtBookQyt.getText();
            String time = txtTimeAddBook.getText();
            String sId = String.valueOf(comBookSupplyerId.getValue());

//
            supplierDetailsTrBO.saveDetails(new BookDTO(bId,bAvalability,bName,bAuthor,bCategory,bRackNo,bQyt,time,sId));

        }catch (Exception ex){

        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {  // Update books
        String bId = txtBookId.getText();
        String bAvalability = String.valueOf(cmbBookAvalability.getValue());
        String bName = txtBookName.getText();
        String bAuthor = txtBookAuthor.getText();
        String bCategory = txtBookCategory.getText();
        String bRackNo = txtRackNo.getText();
        String bQyt = txtBookQyt.getText();
       String time = txtTimeAddBook.getText();
;
        bookBO.updateBook(new BookDTO(bId,bAvalability,bName,bAuthor,bCategory,bRackNo,bQyt,time));

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {  // Delete books
       // boolean isDelete = BookDAOImpl.deleteBook(txtBookId.getText());
        bookBO.deleteBook(txtBookId.getText());

        clearText();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException { // Search books


        BookDTO book = bookBO.searchBook(txtBookId.getText());
        //BookDTO book = BookDAOImpl.searchBook(txtBookId.getText());
        if(book!=null){

            cmbBookAvalability.setValue(book.getbAvalability());
            txtBookName.setText(book.getbName());
            txtBookAuthor.setText(book.getbAuthor());
            txtBookCategory.setText(book.getbCategory());
            txtRackNo.setText(book.getbRackNo());
            txtBookQyt.setText(book.getbQyt());

        }
    }



    public void clearText(){
        txtBookId.setText("");//  Clesr txt feled
        txtBookName.setText("");
        txtBookAuthor.setText("");
        txtBookCategory.setText("");
        txtRackNo.setText("");
        txtBookQyt.setText("");

    }

    public void txtCategoryOnAction(ActionEvent actionEvent) {
        txtBookQyt.requestFocus();
    }

    public void txtAuthorOnAction(ActionEvent actionEvent) {
        txtRackNo.requestFocus();
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        txtBookCategory.requestFocus();
    }

    public void txtBookIdOnAction(ActionEvent actionEvent) {
        txtBookName.requestFocus();
    }

    public void txtRackNoOnAction(ActionEvent actionEvent) {
        cmbBookAvalability.requestFocus();
    }

    public void txtQytOnAction(ActionEvent actionEvent) {
        txtBookAuthor.requestFocus();
    }

    public void comAvalabilityOnAction(ActionEvent actionEvent) {
        comBookSupplyerId.requestFocus();
    }
}
