package lk.ijse.libraryManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.bo.BookBO;
import lk.ijse.libraryManagementSystem.dao.BookDAO;
import lk.ijse.libraryManagementSystem.dao.impl.BookDAOImpl;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;
import lk.ijse.libraryManagementSystem.entity.Book;
import lk.ijse.libraryManagementSystem.util.DAOFactory;
import rex.utils.S;

import java.sql.SQLException;

public class BookBOImpl implements BookBO {


    public BookDAO bookDAO = (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);

    @Override
    public void saveBook(BookDTO dto) throws SQLException, ClassNotFoundException {
        bookDAO.save(new Book(dto.getbId(),dto.getbAvalability(),dto.getbName(),dto.getbAuthor(),dto.getbCategory(),dto.getbRackNo(),dto.getbQyt(),dto.getbAddTime()));
    }

    @Override
    public void updateBook(BookDTO dto) throws SQLException, ClassNotFoundException {
        bookDAO.update(new Book(dto.getbId(),dto.getbAvalability(),dto.getbName(),dto.getbAuthor(),dto.getbCategory(),dto.getbRackNo(),dto.getbQyt(),dto.getbAddTime()));
    }

    @Override
    public void deleteBook(String id) throws SQLException, ClassNotFoundException {
        bookDAO.delete(id);
    }

    @Override
    public BookDTO searchBook(String id) throws SQLException, ClassNotFoundException {
        Book book = bookDAO.search(id);
        return new BookDTO(
                book.getBookID(),book.getBookAvalability(),book.getBookName(),book.getBookAuthor(),book.getBookCategorie(),book.getBookRackNo(),book.getQyt(),book.getBookAddedTime());
    }

    @Override
    public String  getLastBookId()throws SQLException, ClassNotFoundException{
        return bookDAO.generateNewID();
    }
}
