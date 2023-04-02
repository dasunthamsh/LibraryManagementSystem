package lk.ijse.libraryManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dao.CrudDAO;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;

import java.sql.SQLException;

public interface BookBO extends SuperBO {


      void saveBook(BookDTO dto) throws SQLException, ClassNotFoundException ;

      void updateBook(BookDTO dto) throws SQLException, ClassNotFoundException ;

      void deleteBook(String id) throws SQLException, ClassNotFoundException ;

     BookDTO searchBook(String id) throws SQLException, ClassNotFoundException ;

     String getLastBookId() throws SQLException, ClassNotFoundException ;



}
