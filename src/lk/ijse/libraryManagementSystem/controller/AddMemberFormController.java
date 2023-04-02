package lk.ijse.libraryManagementSystem.controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.libraryManagementSystem.bo.BookBO;
import lk.ijse.libraryManagementSystem.bo.MemberBO;
import lk.ijse.libraryManagementSystem.bo.impl.MemberBOImpl;
import lk.ijse.libraryManagementSystem.dao.impl.BookDAOImpl;
import lk.ijse.libraryManagementSystem.dao.impl.MemberDAOImpl;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;
import lk.ijse.libraryManagementSystem.entity.Member;
import lk.ijse.libraryManagementSystem.util.BOFactory;
import lk.ijse.libraryManagementSystem.util.CrudUtil;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddMemberFormController implements Initializable {

    public JFXTextField txtMemberName;
    public JFXTextField txtMemberEmail;
    public JFXTextField txtMemberAddress;
    public JFXTextField txtMemberNumber;
    public JFXTextField txtMemberId;
    public AnchorPane pane;
    public TableColumn tblMemberId;
    public TableColumn btnName;
    public TableColumn tblNumber;
    public TableColumn tblAddress;
    public TableColumn tblEmail;
    public TableView tblAddMember;


    MemberBO memberBO = (MemberBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEMBER);

    public void initialize(URL location, ResourceBundle resources) {
        lodeMemberData();
        setCellValueFactory();
        lodeNextMemberId();
        clearTxt();
    }

    public void lodeNextMemberId(){
        try {
           MemberBO memberBO = new MemberBOImpl();
           String id = memberBO.generateNewMemberID();
            txtMemberId.setText(id);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    public void btnAddOnAction(ActionEvent actionEvent) {

        String id = txtMemberId.getText();
        String name = txtMemberName.getText();
        String address = txtMemberAddress.getText();
        String email = txtMemberEmail.getText();
        String number = txtMemberNumber.getText();

        try {
            memberBO.saveMember(new MemberDTO(id, name, address, email, number));



        } catch (Exception e) {
            e.printStackTrace();
        }
       clearTxt();
    }
        public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
            String id = txtMemberId.getText();
            String name = txtMemberName.getText();
            String address = txtMemberAddress.getText();
            String email = txtMemberEmail.getText();
            String number = txtMemberNumber.getText();

            memberBO.updateMember(new MemberDTO(id,name,address,email,number));
                clearTxt();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        memberBO.deleteMember(txtMemberId.getText());


        clearTxt();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        MemberDTO member = memberBO.searchMember(txtMemberId.getText());
        if(member!=null){
            txtMemberName.setText(member.getName());
            txtMemberAddress.setText(member.getAddress());
            txtMemberEmail.setText(member.getEmail());
          txtMemberNumber.setText(member.getNumber());
        }
    }

    public void lodeMemberData(){
        try {
            ObservableList<MemberDTO> member = MemberDAOImpl.searchAllMembers();
            tblAddMember.setItems(member);
        }catch (Exception e){

        }

    }
    public void setCellValueFactory(){
        tblMemberId.setCellValueFactory(new PropertyValueFactory("id"));
        btnName.setCellValueFactory(new PropertyValueFactory("name"));
        tblAddress.setCellValueFactory(new PropertyValueFactory("address"));
        tblEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tblNumber.setCellValueFactory(new PropertyValueFactory("number"));
    }



    public void clearTxt(){
        txtMemberId.setText("");
        txtMemberName.setText("");
        txtMemberAddress.setText("");
        txtMemberEmail.setText("");
        txtMemberNumber.setText("");
    }

    public void txtNameOnAction(ActionEvent actionEvent) {
        txtMemberNumber.requestFocus();
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
        txtMemberEmail.requestFocus();
    }

    public void txtNumberOnAction(ActionEvent actionEvent) {
        txtMemberAddress.requestFocus();
    }

    public void txtMemberIdOnAction(ActionEvent actionEvent) {
        txtMemberName.requestFocus();
    }
}
