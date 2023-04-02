package lk.ijse.libraryManagementSystem.util;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.bo.SuperBO;
import lk.ijse.libraryManagementSystem.bo.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){
    }

    public static BOFactory getBoFactory(){
        return boFactory==null? boFactory = new BOFactory():boFactory;
    }

    public enum BOTypes{

        MEMBER,BOOK,SUPPLYER,SuppliyerDetailsTr,IssuedDetailsBOImpl,RETURNBOOK,DASHBORD
    }

    public SuperBO getBO(BOTypes boTypes){

        switch (boTypes){
            case MEMBER:return new MemberBOImpl();
            case BOOK:return new BookBOImpl();
            case SUPPLYER:return new SupplyerBOImpl();
            case SuppliyerDetailsTr:return new SupplierDetailsTrBOImpl();
            case IssuedDetailsBOImpl:return new IssuedDetailsBOImpl();
            case RETURNBOOK: return new ReturnDetailsBOImpl();
            case DASHBORD:return new DashBoardBOImpl();
            default:return null;
        }
    }
}




