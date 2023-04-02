package lk.ijse.libraryManagementSystem.controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.libraryManagementSystem.bo.SupplyerBO;
import lk.ijse.libraryManagementSystem.bo.impl.SupplyerBOImpl;
import lk.ijse.libraryManagementSystem.dto.SupplyerDTO;
import lk.ijse.libraryManagementSystem.dao.impl.SupplyerDAOImpl;
import lk.ijse.libraryManagementSystem.util.BOFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SupplyerFormController implements Initializable {
    public JFXTextField txtSupplyerName;
    public JFXTextField txtSupplyerNumber;
    public JFXTextField txtSupplyerEmail;
    public JFXTextField txtSupplyerId;
    public TableView tblSupplyer;
    public TableColumn tblSupplyerId;
    public TableColumn tblSupplyerName;
    public TableColumn tblSupplyerNumber;
    public TableColumn tblSupplyerEmail;


    SupplyerBO supplyerBO = (SupplyerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLYER);
   // ObservableList<SupplyerDTO> supplierTMS = FXCollections.observableArrayList();
    public void initialize(URL location, ResourceBundle resources) {

//setCellValueFactory();
//       lodeSupplierData();
        lodeNextSupplierId();
   }

    public void lodeNextSupplierId(){
        try {
            SupplyerBO supplyerBO = new SupplyerBOImpl();
            String id = supplyerBO.getLastSupplyerId();
            txtSupplyerId.setText(id);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }
//    public void lodeSupplierDetails(){
//        try {
//            ObservableList<SupplyerDTO> supplyers = SupplyerDAOImpl.searchAllSuppler();
//            tblSupplyer.setItems(supplyers);
//        }catch (Exception ex){
//
//        }

   // }





    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String sId = txtSupplyerId.getText();
        String sName = txtSupplyerName.getText();
        String sEmail = txtSupplyerEmail.getText();
        String sNo = txtSupplyerNumber.getText();

        supplyerBO.saveSupplyer(new SupplyerDTO(sId,sName,sEmail,sNo));

//        SupplyerDTO supplyer = new SupplyerDTO(sId,sName,sEmail,sNo);
//        boolean isAdded = SupplyerDAOImpl.addSupplyer(supplyer);


        clearTxt();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String sid = txtSupplyerId.getText();
        String sName = txtSupplyerName.getText();
        String sEmai = txtSupplyerEmail.getText();
        String sNo = txtSupplyerNumber.getText();

        supplyerBO.updateSupplyer(new SupplyerDTO(sid,sName,sEmai,sNo));


//        SupplyerDTO supplyer = new SupplyerDTO(sid,sName,sEmai,sNo);
//        boolean isUpdate = SupplyerDAOImpl.updateSupplyer(supplyer);

        clearTxt();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        supplyerBO.deleteSupplyer(tblSupplyerId.getText());

       // boolean isDeleted = SupplyerDAOImpl.deleteSupplyer(txtSupplyerId.getText());

       clearTxt();
    }



    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        SupplyerDTO supplyer = supplyerBO.searchSupplyer(txtSupplyerId.getText());

      //  SupplyerDTO supplyer = SupplyerDAOImpl.searchSupplyer(txtSupplyerId.getText());
        if(supplyer!=null){
            txtSupplyerName.setText(supplyer.getsName());
            txtSupplyerEmail.setText(supplyer.getsEmail());
            txtSupplyerNumber.setText(supplyer.getsNo());
        }
    }

//    public void lodeSupplierData(){
//        try {
//            ObservableList<SupplyerDTO> supplyers = SupplyerDAOImpl.searchAllSupplier();
//            tblSupplyer.setItems(supplyers);
//        }catch (Exception e){
//
//        }
//
//    }
//    public void setCellValueFactory(){
//        tblSupplyerId.setCellValueFactory(new PropertyValueFactory("supplierID"));
//        tblSupplyerName.setCellValueFactory(new PropertyValueFactory("suppliersName"));
//        tblSupplyerEmail.setCellValueFactory(new PropertyValueFactory("suppliersGmail"));
//        tblSupplyerNumber.setCellValueFactory(new PropertyValueFactory("suppliersNo"));
//
//    }

    public void clearTxt(){
        txtSupplyerId.setText("");
        txtSupplyerName.setText("");
        txtSupplyerEmail.setText("");
        txtSupplyerNumber.setText("");


    }

    public void txtSupplyerNameOnAction(ActionEvent actionEvent) {
        txtSupplyerEmail.requestFocus();
    }

    public void txtSupplyerEmailOnAction(ActionEvent actionEvent) {
        txtSupplyerNumber.requestFocus();
    }

    public void txtSupplyerIdOnAction(ActionEvent actionEvent) {
        txtSupplyerName.requestFocus();
    }




}
