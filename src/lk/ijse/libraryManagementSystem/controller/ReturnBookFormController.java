package lk.ijse.libraryManagementSystem.controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.libraryManagementSystem.bo.ReturnBookBo;
import lk.ijse.libraryManagementSystem.dao.ReturnDAO;
import lk.ijse.libraryManagementSystem.dao.impl.IssueingDAOImpl;
import lk.ijse.libraryManagementSystem.dto.ReturnDTO;
import lk.ijse.libraryManagementSystem.bo.impl.ReturnDetailsBOImpl;
import lk.ijse.libraryManagementSystem.dao.impl.ReturnDAOImpl;
import lk.ijse.libraryManagementSystem.util.BOFactory;
import lk.ijse.libraryManagementSystem.util.CrudUtil;
import lk.ijse.libraryManagementSystem.util.DAOFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReturnBookFormController implements Initializable {
    public ComboBox comBookId;
    //public ComboBox comMemberId;
    public JFXTextField txtAvalibility;
    public ComboBox comAvalability;
    public JFXTextField txtReturnDate;
    public TextField txtDaysElap;
    public TextField txtFine;
    public JFXTextField txtDueDate;
    public JFXTextField txtBookId;
    public JFXTextField txtqyt;
    public JFXTextField comMemberId;

    ReturnDAOImpl returnBookBo = (ReturnDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RETURN);
    public void initialize(URL location, ResourceBundle resources) {
        //lodeBookId();
        returnDate();

    }

    public void returnDate(){
        LocalDate date = LocalDate.now();
        txtReturnDate.setText(String.valueOf(date));
    }




    private void lodeBookId() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = IssueingDAOImpl.lodeBookId();

            for (String id : idList){
                observableList.add(id);
            }
            comBookId.setItems(observableList);
        }catch (Exception e){

        }

    }






    public void btnReturnOnAction(ActionEvent actionEvent) {
        try {
            String mId = comMemberId.getText();
            String bId = txtBookId.getText();
            String rtnDate = txtReturnDate.getText();
            String dueDate = txtDueDate.getText();
            int avalability = Integer.parseInt(txtqyt.getText());



            ReturnDAOImpl returnDAO = (ReturnDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RETURN);
            returnDAO.addreturnTbl(new ReturnDTO(mId,bId , rtnDate , dueDate ,avalability));

        }catch (Exception ex){
        System.out.println(ex);
        }
        txtClener();
    }

    public void txtDasElapOnAction(ActionEvent actionEvent) {

    }

    public void txtFinrOnAction(ActionEvent actionEvent) {
    }

    public void txtDueDateOnAction(ActionEvent actionEvent) {


    }

    public void comLodeDueDate(ActionEvent actionEvent) {

        try {
           ReturnDTO returne = returnBookBo.searchDueDate(comMemberId.getText());
         //   ReturnDTO aReturn = ReturnDAOImpl.searchDueDate(comMemberId.getText());
            if(returne!=null){

                txtBookId.setText(returne.getbId());
                txtqyt.setText(String.valueOf(returne.getAvalability()));
                txtDueDate.setText(returne.getBookdueDate());
            }
        }catch (Exception ex){
            System.out.println(ex);

        }

        try {

            String returnDate = txtReturnDate.getText();
            String dueDate = txtDueDate.getText();
            ResultSet result = CrudUtil.execute("SELECT DATEDIFF('"+returnDate+"','"+dueDate+"') AS days FROM returnBook"
            );
            if(result.next()){
                int dayElap = result.getInt(1);
                txtDaysElap.setText(String.valueOf(dayElap));

                if(dayElap>0){
                    int fine  = dayElap * 10;
                    txtFine.setText(String.valueOf(fine));

                }
            }

        }catch (Exception ex){

        }
    }

    public void comLodeMemberId(ActionEvent actionEvent) {

    }
    public void txtClener(){
        comMemberId.setText("");
        txtBookId.setText("");
        txtqyt.setText("");
        txtDueDate.setText("");



    }
}
