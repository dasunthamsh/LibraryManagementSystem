package lk.ijse.libraryManagementSystem.dao.impl;/*
    @author Dasun
*/

import javafx.scene.control.Alert;
import lk.ijse.libraryManagementSystem.dao.IssueingDAO;
import lk.ijse.libraryManagementSystem.dao.SuperDAO;
import lk.ijse.libraryManagementSystem.dto.IssueDTO;
import lk.ijse.libraryManagementSystem.entity.Issued;
import lk.ijse.libraryManagementSystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IssueingDAOImpl implements IssueingDAO {
    public static ArrayList<String> lodeBookId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT bookID FROM book";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();
        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }

    public static ArrayList<String> lodeMemberId() throws SQLException, ClassNotFoundException {
        String sql ="SELECT memberID FROM member";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();
        while (result.next()){
            idList.add(result.getString(1));
        }
        return idList;
    }

    public boolean issueBook(Issued issue) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("INSERT INTO issued VALUES (?,?,?,?,?,?)",
                issue.getMemberID(),
                issue.getBookID(),
                issue.getTime(),
                issue.getDate(),
                issue.getDuedate(),
                issue.getBookAvalability())) {
            new Alert(Alert.AlertType.CONFIRMATION,"book issue").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Allmost Issued").show();
        }

        return false;
    }
    public boolean updataBookData(String bid , String avalability) throws SQLException, ClassNotFoundException {
        CrudUtil.execute("UPDATE book SET qyt = qyt - ? WHERE bookID = ?  ",bid,avalability);
//        avbl.getAvalability();
//        avbl.getbId();
        return false;
    }



}
