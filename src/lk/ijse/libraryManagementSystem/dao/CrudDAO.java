package lk.ijse.libraryManagementSystem.dao;/*
    @author Dasun
*/

import java.sql.SQLException;

public interface CrudDAO < T, ID > extends SuperDAO{

      boolean save(T dto) throws SQLException, ClassNotFoundException ;

      void update(T dto) throws SQLException, ClassNotFoundException ;

      void delete(ID id) throws SQLException, ClassNotFoundException ;

      T search(ID id) throws SQLException, ClassNotFoundException ;

      String generateNewID() throws SQLException, ClassNotFoundException;


}
