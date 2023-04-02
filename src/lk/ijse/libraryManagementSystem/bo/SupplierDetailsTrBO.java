package lk.ijse.libraryManagementSystem.bo;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.dto.BookDTO;
import lk.ijse.libraryManagementSystem.dto.SupplyerDTO;

import java.sql.SQLException;

public interface SupplierDetailsTrBO extends SuperBO {
      boolean saveDetails (BookDTO dto ) throws SQLException, ClassNotFoundException ;

}
