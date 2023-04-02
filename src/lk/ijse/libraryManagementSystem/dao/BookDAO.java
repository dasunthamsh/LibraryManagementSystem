package lk.ijse.libraryManagementSystem.dao;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dao.CrudDAO;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.IssueDTO;
import lk.ijse.libraryManagementSystem.dto.ReturnDTO;
import lk.ijse.libraryManagementSystem.dto.SupplyerDTO;
import lk.ijse.libraryManagementSystem.entity.Book;
import lk.ijse.libraryManagementSystem.entity.Issued;
import lk.ijse.libraryManagementSystem.entity.ReturnBook;


import java.sql.SQLException;

public interface BookDAO extends CrudDAO <Book , String> {
    }
