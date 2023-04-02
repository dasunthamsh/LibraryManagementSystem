package lk.ijse.libraryManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.bo.MemberBO;
import lk.ijse.libraryManagementSystem.dao.MemberDAO;
import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.MemberDTO;
import lk.ijse.libraryManagementSystem.entity.Member;
import lk.ijse.libraryManagementSystem.util.DAOFactory;

import java.sql.SQLException;

public class MemberBOImpl implements MemberBO {

    //public MemberDAO memberDAO =(MemberDAO) new MemberBOImpl();
    public MemberDAO memberDAO = (MemberDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MEMBER);


    @Override
    public void saveMember(MemberDTO dto) throws SQLException, ClassNotFoundException {
        memberDAO.save(new Member(dto.getId(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getNumber()));
    }

    @Override
    public void updateMember(MemberDTO dto) throws SQLException, ClassNotFoundException {
        memberDAO.update(new Member(dto.getId(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getNumber()));
    }

    @Override
    public void deleteMember(String id) throws SQLException, ClassNotFoundException {
        memberDAO.delete(id);
    }

    @Override
    public MemberDTO searchMember(String id) throws SQLException, ClassNotFoundException {
         Member member = memberDAO.search(id);//memberDAO.search(id);
         return new MemberDTO(
                 member.getMemberID(),member.getMemberName(),member.getMemberAddress(),member.getMemberEmail(), member.getMemberNumber());

    }

    @Override
    public String generateNewMemberID() throws SQLException, ClassNotFoundException {
        return memberDAO.generateNewID();
    }
}
