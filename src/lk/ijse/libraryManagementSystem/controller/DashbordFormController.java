package lk.ijse.libraryManagementSystem.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.libraryManagementSystem.util.CrudUtil;
import lk.ijse.libraryManagementSystem.util.Navigation;
import lk.ijse.libraryManagementSystem.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;


public class DashbordFormController implements Initializable {

    public Label lblDate;
    public Text texteClock;
    public Text txtNumOfMember;
    public Text txtNoOfBook;
    public Text txtNoOfSuppliers;
    public BarChart barChart;
    public PieChart piechart;
    public Text txtNoOfIssuedBooks;


    public void loadPieChart() {
        ObservableList<PieChart.Data> pieChartData = observableArrayList(
                new PieChart.Data("January", 13),
                new PieChart.Data("February", 25),
                new PieChart.Data("March", 10),
                new PieChart.Data("April", 43),
                new PieChart.Data("April", 25),
                new PieChart.Data("May", 22),
                new PieChart.Data("June", 12),
                new PieChart.Data("July", 82),
                new PieChart.Data("August", 22),
                new PieChart.Data("September", 32),
                new PieChart.Data("October", 24),
                new PieChart.Data("November", 22),
                new PieChart.Data("December", 22));
        piechart.setData(pieChartData);

        XYChart.Series series =new XYChart.Series();
        series.getData().add(new XYChart.Data("1",23));
        series.getData().add(new XYChart.Data("2",65));
        series.getData().add(new XYChart.Data("3",68));
        series.getData().add(new XYChart.Data("4",32));
        series.getData().add(new XYChart.Data("5",56));
        series.getData().add(new XYChart.Data("6",76));
        series.getData().add(new XYChart.Data("7",44));
        series.getData().add(new XYChart.Data("8",68));
        series.getData().add(new XYChart.Data("9",32));
        series.getData().add(new XYChart.Data("10",56));
        series.getData().add(new XYChart.Data("11",76));
        series.getData().add(new XYChart.Data("12",44));
        barChart.getData().add(series);

    }
    private void noOfIssuedBook(){
        try {
            String sql = "SELECT COUNT(*) FROM issued";
            ResultSet result = CrudUtil.execute(sql);
            if(result.next()){
                int memberCount = result.getInt(1);
                txtNoOfIssuedBooks .setText(String.valueOf(memberCount));
            }
        }catch (Exception ex){

        }
    }
    private void noOfMember()  {
        try {
            String sql = "SELECT COUNT(*) FROM member";
            ResultSet result = CrudUtil.execute(sql);
            if(result.next()){
                int memberCount = result.getInt(1);
                txtNumOfMember .setText(String.valueOf(memberCount));
            }
        }catch (Exception ex){

        }

    }
    private void noOfBook(){
        try {
            String sql = "SELECT COUNT(*) FROM book";
            ResultSet result = CrudUtil.execute(sql);
            if(result.next()){
                int memberCount = result.getInt(1);
                txtNoOfBook .setText(String.valueOf(memberCount));
            }
        }catch (Exception ex){

        }
    }

    private void noOfSupplier(){
        try {
            String sql = "SELECT COUNT(*) FROM supplier";
            ResultSet result = CrudUtil.execute(sql);
            if(result.next()){
                int memberCount = result.getInt(1);
                txtNoOfSuppliers .setText(String.valueOf(memberCount));
            }
        }catch (Exception ex){


        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        setDate();
        setTime();
        noOfMember();
        noOfBook();
        noOfSupplier();
        loadPieChart();
        noOfIssuedBook();



        }



    private void setDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(dateFormat.format(new Date()));
    }

    private void setTime(){
        Thread clock = new Thread() {
            public void run() {
                while (true) {
                    DateFormat hour = new SimpleDateFormat("hh:mm:ss");
                    texteClock.setText(hour.format(new Date()));

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        clock.start();

    }

    public void initialize(){
        LocalDate date = LocalDate.now();
        lblDate.setText(String.valueOf(date));
    }

    public AnchorPane contex;
    public TextField txtClock;
    @FXML
    private AnchorPane pane;


    public void btnDashbordOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBORD,pane);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    public void btnAddMemberOnAction(ActionEvent actionEvent) throws IOException {

        setUi("/lk/ijse/libraryManagementSystem/view/AddMemberForm");

    }

    public void setUi(String ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        contex.getChildren().clear();
        contex.getChildren().add(node);

    }

    public void btnAddBookOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/libraryManagementSystem/view/AddBookForm");
    }

    public void btnAddSupplyerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/libraryManagementSystem/view/SupplyerForm");
    }

    public void btnIshudeBookOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/libraryManagementSystem/view/IssuingBookForm");
    }

    public void btnReportOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/libraryManagementSystem/view/Report");
    }

    public void btnReturnBookOnAction(ActionEvent actionEvent) throws IOException {
        setUi("/lk/ijse/libraryManagementSystem/view/ReturnBookForm");
    }
}
