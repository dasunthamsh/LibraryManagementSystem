package lk.ijse.libraryManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dto.ReturnDTO;

import java.sql.SQLException;

public interface ReturnBookBo extends SuperBO{

    boolean returnedBook(ReturnDTO trn) throws SQLException, ClassNotFoundException;

}
