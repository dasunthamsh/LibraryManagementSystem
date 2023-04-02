package lk.ijse.libraryManagementSystem.dao.impl;/*
    @author Dasun
*/

import javafx.scene.control.Alert;
import lk.ijse.libraryManagementSystem.dao.SupplyerDAO;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.entity.Book;
import lk.ijse.libraryManagementSystem.entity.Supplier;
import lk.ijse.libraryManagementSystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplyerDAOImpl implements SupplyerDAO {

    public boolean save(Supplier supplyer) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("INSERT INTO supplier VALUES (?,?,?,?)",supplyer.getSupplierID() , supplyer.getSuppliersName() , supplyer.getSuppliersGmail() , supplyer.getSuppliersNo())
){
            new Alert(Alert.AlertType.CONFIRMATION,"SupplyerDTO Added SUccessful").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Somthing Was Worng").show();
        }
        return false;
    }

    public void update(Supplier supplyer) throws SQLException, ClassNotFoundException {

        if(CrudUtil.execute("UPDATE supplier SET   suppliersName = ? , suppliersGmail = ? , suppliersNo = ? WHERE supplierID = ?"
                 , supplyer.getSuppliersName() , supplyer.getSuppliersGmail() , supplyer.getSuppliersNo(),supplyer.getSupplierID())){
            new Alert(Alert.AlertType.CONFIRMATION,"SupplyerDTO Update Successful").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Somthig Was Wrong").show();
        }

    }


    public  Supplier search(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM supplier WHERE supplierID = '"+id+"'");
            if(result.next()){
                return new Supplier(result.getString("supplierID"),result.getString("suppliersName"),result.getString("suppliersGmail"),result.getString("suppliersNo"));
            }
            return null;
    }




    public void delete(String sId) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("DELETE  FROM supplier WHERE supplierID = '"+sId+"'")){
            new Alert(Alert.AlertType.CONFIRMATION,"SupplyerDTO Delete Successful").show();
        }else
            new Alert(Alert.AlertType.CONFIRMATION,"Somthig Was Wrong").show();
    }



    public  String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT supplierID FROM supplier ORDER BY supplierID DESC LIMIT 1");
        if(result.next()){
            return generateNextSupplierId(result.getString(1));
        }
        return generateNextSupplierId(result.getString(null));
    }

    private static String generateNextSupplierId(String currentSupplierId) {
        if(currentSupplierId != null){
            String[] split = currentSupplierId.split("S0");
            int id = Integer.parseInt(split[1]);
            id+=1;
            return "S0" + id;
        }
        return "S001";
    }

    public boolean addeSupplierDetails(String getbAddTime, String getbId, String getsId) throws SQLException, ClassNotFoundException {
         CrudUtil.execute("INSERT INTO supplierdetail VALUES (?,?,?)",getbAddTime,getbId,getsId);
//                 book.getBookAddedTime(),
//                 book.getBookID(),
//                 book.getSupplierID());

        return false;
    }




//    public static ObservableList<SupplyerDTO> searchAllSupplier() throws SQLException, ClassNotFoundException {
//        ObservableList<SupplyerDTO> list = FXCollections.observableArrayList();
//        String sql = "SELECT * FROM supplier";
//        ResultSet result = CrudUtil.execute(sql);
//        while (result.next()){
//            SupplyerDTO supplyer = new SupplyerDTO(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
//            list.add(supplyer);
//        }
//        return list;
//    }
}

