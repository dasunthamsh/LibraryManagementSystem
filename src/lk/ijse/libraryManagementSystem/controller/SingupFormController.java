package lk.ijse.libraryManagementSystem.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.libraryManagementSystem.dao.impl.SignupDAOImpl;
import lk.ijse.libraryManagementSystem.dto.SignupDTO;
import lk.ijse.libraryManagementSystem.util.Navigation;
import lk.ijse.libraryManagementSystem.util.Routes;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingupFormController {


    public JFXCheckBox checkBox;
    public Button btnRegister;
    public Label showError;
    public JFXTextField txtPasswordcomPassword1;
    @FXML
    private AnchorPane pane;
    public JFXTextField txtUsername;
    public JFXTextField txtId;
    public JFXTextField txtPassword;
    public JFXTextField txtName;

    private Matcher LidMatcher;
    private Matcher nameMatcher;
    private Matcher userMatcher;
    private Matcher PasswordMatcher;

    public void initialize(){
        redTopId();
        redTopName();
        redTopUsername();
        redTopPassword();
    }

    public void btnRegisternOnAction(ActionEvent actionEvent) throws IOException {

        String Lid = txtId.getText();
        String Lname = txtName.getText();
        String Lusername = txtUsername.getText();
        String LPassword = txtPassword.getText();




            SignupDTO signup = new SignupDTO(Lid, Lname, Lusername, LPassword);
            try {
                boolean isAdded = SignupDAOImpl.save(signup);

                if (isAdded) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Register Complete").show();
                } else {
                    new Alert(Alert.AlertType.CONFIRMATION, "Plece tryagane").show();

                }
            } catch (Exception ex) {
                System.out.println(ex);
            }


        Navigation.navigate(Routes.LOGIN, pane);
    }
    private void redTopId(){
        setPattenId();
        if(!LidMatcher.matches()){
            txtId.setFocusColor(Paint.valueOf("red"));

        }
    }

    private void redTopName(){
        setPattenName();
        if(!nameMatcher.matches()){
            txtName.setFocusColor(Paint.valueOf("red"));

        }
    }

    private void redTopUsername(){
        setPattenUsername();
        if(!userMatcher.matches()){
            txtUsername.setFocusColor(Paint.valueOf("red"));

        }
    }

    private void redTopPassword(){
        setPattenPassword();
        if(!PasswordMatcher.matches()){
            txtPassword.setFocusColor(Paint.valueOf("red"));

        }
    }

private void setPattenId(){
    Pattern LidPattern = Pattern.compile("^(U0)([0-9]{1,})([1-9]{0,})$");
    LidMatcher = LidPattern.matcher(txtId.getText());

}
    private void setPattenName(){
        Pattern namePattern = Pattern.compile("^(U0)([0-9]{1,})([1-9]{0,})$");
        nameMatcher = namePattern.matcher(txtName.getText());

    }

    private void setPattenUsername(){
        Pattern usernamePattern = Pattern.compile("^(U0)([0-9]{1,})([1-9]{0,})$");
        userMatcher = usernamePattern.matcher(txtUsername.getText());

    }

    private void setPattenPassword(){
        Pattern passwordPattern = Pattern.compile("^(U0)([0-9]{1,})([1-9]{0,})$");
        PasswordMatcher = passwordPattern.matcher(txtPassword.getText());

    }



    public void checkBoxOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void lodePasswordOnAction(ActionEvent actionEvent) {
    }

    public void lodeNameOnAction(ActionEvent actionEvent) {
    }

    public void lodeUserOnAction(ActionEvent actionEvent) {
    }

    public void regesterOnAction(ActionEvent actionEvent) {
    }

    public void LoderegesterOnAction(ActionEvent actionEvent) {
    }

    public void lodeComformPassword(ActionEvent actionEvent) {
    }
}
