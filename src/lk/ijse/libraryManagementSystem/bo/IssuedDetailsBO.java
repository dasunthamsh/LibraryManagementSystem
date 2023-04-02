package lk.ijse.libraryManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dto.IssueDTO;

import java.sql.SQLException;

public interface IssuedDetailsBO extends SuperBO{

    public  boolean issuedBook(IssueDTO issue) throws SQLException, ClassNotFoundException;
}
