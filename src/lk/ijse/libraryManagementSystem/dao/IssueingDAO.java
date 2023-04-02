package lk.ijse.libraryManagementSystem.dao;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dto.IssueDTO;
import lk.ijse.libraryManagementSystem.entity.Issued;

import java.sql.SQLException;

public interface IssueingDAO extends SuperDAO{

    boolean  issueBook(Issued issued) throws SQLException, ClassNotFoundException;

    public boolean updataBookData(String bid , String avalability) throws SQLException, ClassNotFoundException;


}
