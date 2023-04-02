package lk.ijse.libraryManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;
import lk.ijse.libraryManagementSystem.entity.Member;

import java.sql.SQLException;

public interface MemberBO extends SuperBO {

    public   void saveMember(MemberDTO dto) throws SQLException, ClassNotFoundException ;

    public  void updateMember(MemberDTO dto) throws SQLException, ClassNotFoundException ;

    public  void deleteMember(String id) throws SQLException, ClassNotFoundException ;

    public MemberDTO searchMember(String id) throws SQLException, ClassNotFoundException ;

    String generateNewMemberID() throws SQLException, ClassNotFoundException;

}
