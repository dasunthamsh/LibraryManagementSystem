package lk.ijse.libraryManagementSystem.controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lk.ijse.libraryManagementSystem.bo.IssuedDetailsBO;
import lk.ijse.libraryManagementSystem.dao.impl.BookDAOImpl;
import lk.ijse.libraryManagementSystem.bo.impl.IssuedDetailsBOImpl;
import lk.ijse.libraryManagementSystem.dao.impl.IssueingDAOImpl;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.IssueDTO;
import lk.ijse.libraryManagementSystem.util.BOFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IssuingBookFormController implements Initializable {
    public ComboBox comBookId;
    public ComboBox comMemberId1;
   // public ComboBox comAvalability;
    public DatePicker comDueDate;
    public JFXTextField txtLocalDate;
    public JFXTimePicker comDuetime;
    public TextField txtBookName;
    public TextField txtRackNo;
    public Label comAvailability;
    public Label txtLocalDatee;

        IssuedDetailsBO issuedDetailsBO = (IssuedDetailsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.IssuedDetailsBOImpl);

    public void initialize(URL location, ResourceBundle resources) {
        lodeBookId();
        lodeMemberId();
        bookAddTime();

    }

    public void bookAddTime() {
        LocalDate date = LocalDate.now();
        txtLocalDatee.setText(String.valueOf(date));
    }



    private void lodeBookId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = IssueingDAOImpl.lodeBookId();

            for (String id : idList) {
                observableList.add(id);
            }
            comBookId.setItems(observableList);
        } catch (Exception e) {

        }

    }


    private void lodeMemberId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = IssueingDAOImpl.lodeMemberId();

            for (String id : idList) {
                observableList.add(id);
            }
            comMemberId1.setItems(observableList);
        } catch (Exception e) {

        }


    }


    public void btnIssueOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
        String bId = String.valueOf(comBookId.getValue());
        String mId = String.valueOf(comMemberId1.getValue());
        String avalability = comAvailability.getText();
        String dueDte = String.valueOf(comDueDate.getValue());
        String dueTime = String.valueOf(comDuetime.getValue());
        String localTime = txtLocalDatee.getText();


            issuedDetailsBO.issuedBook(new IssueDTO(bId,mId,dueDte,dueTime,localTime,avalability));

    //    IssueDTO issue = new IssueDTO(bId, mId, dueDte, dueTime, localTime ,avalability);

//        boolean isPlased = IssuedDetailsBOImpl.issuedBook(issue);
//        if(isPlased) {
//            new Alert(Alert.AlertType.CONFIRMATION,"book issue").show();
//        }else {
//            new Alert(Alert.AlertType.ERROR,""+mId+"Allmost Issued").show();
//        }

        }catch (Exception ex){
            System.out.println(ex);
        }
    }


    public void btnFindRackOnActioin(ActionEvent actionEvent) {
        try {
            BookDTO rackNo = BookDAOImpl.findRackNo(txtBookName.getText());
            txtRackNo.setText(rackNo.getbRackNo());
        } catch (Exception throwables) {
            System.out.println(throwables);
        }


    }


}
