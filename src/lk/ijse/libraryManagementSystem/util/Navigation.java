package lk.ijse.libraryManagementSystem.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.libraryManagementSystem.controller.AddMemberFormController;
import lk.ijse.libraryManagementSystem.controller.DashbordFormController;

import java.io.IOException;

public class Navigation {



    private static AnchorPane pane;
    public static void navigate(Routes routes , AnchorPane pane) throws IOException {

        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (routes){
            case LOGIN:
                window.setTitle(" Login Form");
                initUI("LoginForm.fxml");
                break;
            case  DASHBORD:
                window.setTitle(" Dashbord Form");
                initUI("DashbordForm.fxml");
                break;
            case SIGNUP:
                window.setTitle("Singup Form");
                initUI("SingupForm.fxml");
                break;
            case ADDMEMBER:
                window.setTitle("Add MemberDTO Form");
               initUI("AddMemberForm.fxml");
                break;
            case REENTERPASSWORD:
                window.setTitle("Resat Password Form");
                initUI("ResatPasswordForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR,"Not Sutibale UI found").show();
        }

    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/libraryManagementSystem/view/"+location)));

    }
}
