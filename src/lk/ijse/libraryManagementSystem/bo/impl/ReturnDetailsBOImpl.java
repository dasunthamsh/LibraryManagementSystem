package lk.ijse.libraryManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.bo.ReturnBookBo;
import lk.ijse.libraryManagementSystem.dao.ReturnDAO;
import lk.ijse.libraryManagementSystem.dao.impl.BookDAOImpl;
import lk.ijse.libraryManagementSystem.dao.impl.IssueingDAOImpl;
import lk.ijse.libraryManagementSystem.db.DBConnection;
import lk.ijse.libraryManagementSystem.dto.ReturnDTO;
import lk.ijse.libraryManagementSystem.entity.ReturnBook;
import lk.ijse.libraryManagementSystem.util.DAOFactory;
import org.hibernate.loader.custom.Return;

import java.sql.SQLException;

public class ReturnDetailsBOImpl implements ReturnBookBo {

    ReturnDAO returnDAO = (ReturnDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RETURN);

    public  boolean returnedBook(ReturnDTO trn) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isUpdate = returnDAO.returnUpdataBookData(new ReturnBook(trn.getbId(),trn.getAvalability()));
                    if(isUpdate){
                        boolean isAdded = returnDAO.returnDetails(trn.getmId());
                            if (isAdded){
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
