package lk.ijse.libraryManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dto.SupplyerDTO;

import java.sql.SQLException;

public interface SupplyerBO extends SuperBO{

    public  void saveSupplyer(SupplyerDTO dto) throws SQLException, ClassNotFoundException ;

    public  void updateSupplyer(SupplyerDTO dto) throws SQLException, ClassNotFoundException ;

    public  void deleteSupplyer(String id) throws SQLException, ClassNotFoundException ;

    public SupplyerDTO searchSupplyer(String id) throws SQLException, ClassNotFoundException ;

    String getLastSupplyerId() throws SQLException, ClassNotFoundException ;

}
