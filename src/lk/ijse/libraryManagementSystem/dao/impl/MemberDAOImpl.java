package lk.ijse.libraryManagementSystem.dao.impl;/*
    @author Dasun
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lk.ijse.libraryManagementSystem.dao.MemberDAO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;
import lk.ijse.libraryManagementSystem.entity.Member;
import lk.ijse.libraryManagementSystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAOImpl implements MemberDAO  {

    public boolean save(Member member) throws SQLException, ClassNotFoundException {
        if (CrudUtil.execute( "INSERT INTO member VALUES (?,?,?,?,?)",member.getMemberID() , member.getMemberName() , member.getMemberAddress() , member.getMemberEmail() , member.getMemberNumber())) {
            new Alert(Alert.AlertType.CONFIRMATION, "MemberDTO Added").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Somthing wrong");
        }

        return false;
    }


    public Member search(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM member WHERE memberID = '"+id+"'");
        if(result.next()){
            return  new Member(result.getString("memberID"),result.getString("memberName"),result.getString("memberAddress"),result.getString("memberEmail"),result.getString("memberNumber"));
        }
        return null;
    }




    public  void update(Member member) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute( "UPDATE member SET   memberID = ? , memberName = ? , memberAddress = ? , memberEmail = ? WHERE memberNumber = ?",member.getMemberID() , member.getMemberName() , member.getMemberAddress() , member.getMemberEmail() , member.getMemberNumber())){
            new Alert(Alert.AlertType.CONFIRMATION,"MemberDTO Update Successful").show();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Somthing Wrong").show();
        }

        }


    public void delete(String id) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("DELETE FROM member WHERE memberID = '"+id+"'")){
            new Alert(Alert.AlertType.CONFIRMATION,"MemberDTO Delete Successful").show();
        }
    }


    public static ObservableList<MemberDTO> searchAllMembers() throws SQLException, ClassNotFoundException {
        ObservableList<MemberDTO> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM member";
        ResultSet result = CrudUtil.execute(sql);
        while (result.next()){
            MemberDTO member = new MemberDTO(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
            list.add(member);
        }
        return list;
    }

    public  String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT memberID FROM member ORDER BY memberID DESC LIMIT 1");
        if(result.next()){
            return generateNextMemberId(result.getString(1));
            }
        return generateNextMemberId(result.getString(null));
        }





    private static String generateNextMemberId(String currentMemberId) {
        if(currentMemberId != null){
            String[] split = currentMemberId.split("C0");
            int id = Integer.parseInt(split[1]);
            id+=1;
            return "C0" + id;
        }
        return "C001";
    }

}

