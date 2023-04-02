package lk.ijse.libraryManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.libraryManagementSystem.util.CrudUtil;
import lk.ijse.libraryManagementSystem.util.Navigation;
import lk.ijse.libraryManagementSystem.util.Routes;


import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginFormController {

    public Button btnLogin;
    @FXML
    private  AnchorPane pane;
    @FXML
    public JFXTextField txtUserName;
    @FXML
    public JFXPasswordField txtPassword;

    private Matcher usernameMatcher;
    private Matcher passwordMatcher;

public void initialize(){
   //redTopUsername();
   redTopPassword();
   setPttenUsername();
}

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {


                String username = txtUserName.getText();
                String password = txtPassword.getText();

                String sql = "SELECT * FROM login WHERE loginUsername='"+username+"' AND loginPassword='"+password+"'";
                ResultSet result = CrudUtil.execute(sql);

                if(result.next()){

                    Navigation.navigate(Routes.DASHBORD,pane);
                }else {
                    new Alert(Alert.AlertType.CONFIRMATION, "Please Enter Correct Password and Email ").show();
                }

    }
   /* private void redTopUsername(){
    setPttenUsername();
    if(!usernameMatcher.matches()){
        txtUserName.setFocusColor(Paint.valueOf("red"));
    }
    }*/

    private void redTopPassword(){
        setPttenPassword();
        if(!passwordMatcher.matches()){
            txtPassword.setFocusColor(Paint.valueOf("red"));
            txtUserName.requestFocus();
        }else {
            txtPassword.requestFocus();
        }
    }

    private void setPttenUsername(){
        Pattern usernamePattern = Pattern.compile("^(U0)([0-9]{1,})([1-9]{0,})$");
        usernameMatcher = usernamePattern.matcher(txtUserName.getText());
    }

    private void setPttenPassword(){
        Pattern passwordPattern = Pattern.compile("^(U0)([0-9]{1,})([1-9]{0,})$");
        passwordMatcher = passwordPattern.matcher(txtPassword.getText());
    }




    public void btnSingUpOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SIGNUP,pane);
    }


    public void btnResatePasswordOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.REENTERPASSWORD,pane);
    }

    public void loginOnAction(KeyEvent keyEvent) throws IOException, SQLException, ClassNotFoundException {

    }

    public void txtUsernameOnAction(ActionEvent actionEvent) {
        setPttenUsername();
        if(!usernameMatcher.matches()){
            txtUserName.setFocusColor(Paint.valueOf("red"));
            txtUserName.requestFocus();
        }else {
            txtPassword.requestFocus();
        }
    }

    public void txtPasswordOnAction(ActionEvent mouseEvent) {
        btnLogin.requestFocus();
    }
}
