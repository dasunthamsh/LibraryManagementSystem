package lk.ijse.libraryManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.bo.BookBO;
import lk.ijse.libraryManagementSystem.bo.SupplierDetailsTrBO;
import lk.ijse.libraryManagementSystem.dao.BookDAO;
import lk.ijse.libraryManagementSystem.dao.SupplyerDAO;
import lk.ijse.libraryManagementSystem.dao.impl.BookDAOImpl;
import lk.ijse.libraryManagementSystem.dao.impl.SupplierDetailDAOImpl;
import lk.ijse.libraryManagementSystem.db.DBConnection;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.SupplyerDTO;
import lk.ijse.libraryManagementSystem.entity.Book;
import lk.ijse.libraryManagementSystem.entity.Supplier;
import lk.ijse.libraryManagementSystem.util.DAOFactory;

import java.sql.SQLException;

public class SupplierDetailsTrBOImpl implements SupplierDetailsTrBO {

    BookDAO bookDAOTrance = (BookDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);
    SupplyerDAO supplyerDAO = (SupplyerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLYER);
  @Override
    public  boolean saveDetails(BookDTO dto) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isAdded = bookDAOTrance.save(new Book(dto.getbId(),dto.getbAvalability(),dto.getbName(),dto.getbAuthor(),dto.getbCategory(),dto.getbRackNo(),dto.getbQyt(),dto.getbAddTime()));

         //   boolean isAdded = bookDAOTrance
            if(isAdded){
                boolean isInsert =  supplyerDAO.addeSupplierDetails(dto.getbAddTime(),dto.getbId(),dto.getsId());
                if(isInsert){
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;

        }finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }
}
