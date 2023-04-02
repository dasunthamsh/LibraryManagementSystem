package lk.ijse.libraryManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.bo.IssuedDetailsBO;
import lk.ijse.libraryManagementSystem.dao.IssueingDAO;
import lk.ijse.libraryManagementSystem.dao.impl.BookDAOImpl;
import lk.ijse.libraryManagementSystem.dao.impl.IssueingDAOImpl;
import lk.ijse.libraryManagementSystem.db.DBConnection;
import lk.ijse.libraryManagementSystem.dto.IssueDTO;
import lk.ijse.libraryManagementSystem.entity.Issued;
import lk.ijse.libraryManagementSystem.util.DAOFactory;

import java.sql.SQLException;

public class IssuedDetailsBOImpl implements IssuedDetailsBO {


  IssueingDAO issueingDAO = (IssueingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ISSUED);
//
//    public  boolean issuedBook(IssueDTO issue) throws SQLException, ClassNotFoundException {
//        try {
//            DBConnection.getInstance().getConnection().setAutoCommit(false);
//            boolean isAdded = issueingDAO.issueBook(new Issued(issue.getmId(),issue.getbId(),issue.getDueTime(),issue.getLocalDate(),issue.getDueDate(),issue.getAvalability()));
//            if(isAdded){
//                    boolean isUpdate = issueingDAO.updataBookData(issue.getbId(),issue.getAvalability());
//                        if(isUpdate){
//                                DBConnection.getInstance().getConnection().commit();
//                    return true;
//                }
//            }
//            DBConnection.getInstance().getConnection().rollback();
//            return false;
//        }finally {
//            DBConnection.getInstance().getConnection().setAutoCommit(true);
//        }
//    }

    @Override
    public boolean issuedBook(IssueDTO issue) throws SQLException, ClassNotFoundException {
        issueingDAO.issueBook(new Issued(issue.getmId(),issue.getbId(),issue.getDueTime(),issue.getLocalDate(),issue.getDueDate(),issue.getAvalability()));
        return false;
    }
}
