package lk.ijse.libraryManagementSystem.controller;/*
    @author Dasun
*/

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.libraryManagementSystem.dao.impl.SignupDAOImpl;
import lk.ijse.libraryManagementSystem.dto.SignupDTO;
import lk.ijse.libraryManagementSystem.util.Navigation;
import lk.ijse.libraryManagementSystem.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class ResatPasswordFormController {
    public JFXTextField txtReEnterPassword;
    public JFXTextField txtId;
    public JFXTextField txtPassword;
    public AnchorPane pane;

    public void btnResatPasswordOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        String Lid = txtId.getText();
        String password = txtPassword.getText();

        SignupDTO signup = new SignupDTO(Lid , password);
        boolean isUpdate = SignupDAOImpl.updatePassword(signup);
        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION," Password Update Successful").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Somthing Was Woring").show();

        }


        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }
}
