package lk.ijse.libraryManagementSystem.controller;/*
    @author Dasun
*/

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import lk.ijse.libraryManagementSystem.db.DBConnection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;

public class ReportController {
    public Button txtReport;

    public void btnReportOnAction(ActionEvent actionEvent) {


        try {
            InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/libraryManagementSystem/view/report/Cherry.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(resource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());

            JasperViewer.viewReport(jasperPrint,false);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
