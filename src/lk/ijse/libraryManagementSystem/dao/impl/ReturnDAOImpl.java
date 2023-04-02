package lk.ijse.libraryManagementSystem.dao.impl;/*
    @author Dasun
*/

import javafx.scene.control.Alert;
import lk.ijse.libraryManagementSystem.dao.ReturnDAO;
import lk.ijse.libraryManagementSystem.dto.ReturnDTO;
import lk.ijse.libraryManagementSystem.entity.ReturnBook;
import lk.ijse.libraryManagementSystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnDAOImpl implements ReturnDAO {



    public  ReturnDTO searchDueDate(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM issued WHERE memberID = '"+id+"'";
        ResultSet resultSet = CrudUtil.execute(sql);

        if(resultSet.next()){
            return new ReturnDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6)
                    );
        }
        return null;
    }

    public boolean returnUpdataBookData(ReturnBook update) throws SQLException, ClassNotFoundException {
        CrudUtil.execute("UPDATE book SET qyt = qyt + ? WHERE bookID = ?",update.getBookAvalability(),update.getBookID());
        return false;
    }

    public boolean returnDetails(String id) throws SQLException, ClassNotFoundException {
         CrudUtil.execute("DELETE FROM issued WHERE memberID = '"+id+"'");
        return false;
    }

    public  Void addreturnTbl(ReturnDTO rtn) throws SQLException, ClassNotFoundException {
        if( CrudUtil.execute("INSERT INTO returnbook VALUES (?,?,?,?,?)",
                rtn.getmId(),
                rtn.getbId(),
                rtn.getReturnTime(),
                rtn.getBookdueDate(),
                rtn.getAvalability())){
            new Alert(Alert.AlertType.CONFIRMATION,"book Returnd").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"A").show();
        }
        return null;
    }



}
