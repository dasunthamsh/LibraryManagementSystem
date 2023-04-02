package lk.ijse.libraryManagementSystem.dao;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.entity.Book;
import lk.ijse.libraryManagementSystem.entity.Supplier;

import java.sql.SQLException;

public interface SupplyerDAO extends CrudDAO<Supplier , String> {

   //  boolean addeSupplierDetails(Book book) throws SQLException, ClassNotFoundException;

     boolean addeSupplierDetails(String getbAddTime, String getbId, String getsId) throws SQLException , ClassNotFoundException;
}
