package lk.ijse.libraryManagementSystem.util;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dao.CrudDAO;
import lk.ijse.libraryManagementSystem.dao.IssueingDAO;
import lk.ijse.libraryManagementSystem.dao.SuperDAO;
import lk.ijse.libraryManagementSystem.dao.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return daoFactory==null? daoFactory=new DAOFactory(): daoFactory;
    }

    public enum DAOTypes{

        MEMBER,BOOK,SUPPLYER,ISSUED,RETURN
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case MEMBER:return new MemberDAOImpl();
            case BOOK :return new BookDAOImpl();
            case SUPPLYER:return new SupplyerDAOImpl();
            case ISSUED:return new IssueingDAOImpl();
            case RETURN:return new ReturnDAOImpl();
            default:return null;
        }
    }
}
