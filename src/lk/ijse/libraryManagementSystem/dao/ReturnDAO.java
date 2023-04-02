package lk.ijse.libraryManagementSystem.dao;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.entity.ReturnBook;

import java.sql.SQLException;

public interface ReturnDAO extends SuperDAO {

    public boolean returnUpdataBookData(ReturnBook update) throws SQLException, ClassNotFoundException;

    public boolean returnDetails(String id) throws SQLException, ClassNotFoundException;
}
