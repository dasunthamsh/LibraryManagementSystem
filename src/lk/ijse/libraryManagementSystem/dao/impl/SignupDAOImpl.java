package lk.ijse.libraryManagementSystem.dao.impl;/*
    @author Dasun
*/
import lk.ijse.libraryManagementSystem.dto.SignupDTO;
import lk.ijse.libraryManagementSystem.util.CrudUtil;

import java.sql.SQLException;

public class SignupDAOImpl {
    public static boolean save(SignupDTO signup) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO login VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,signup.getLid(),signup.getLname(),signup.getLusername(),signup.getLPassword());
    }

    public static boolean updatePassword(SignupDTO signup) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE login SET loginPassword = ?  WHERE lbrarianID = ?";
        return CrudUtil.execute(sql,signup.getLPassword(),signup.getLid());
    }
}
