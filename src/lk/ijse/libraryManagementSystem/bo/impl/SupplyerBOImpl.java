package lk.ijse.libraryManagementSystem.bo.impl;/*
    @author Dasun
*/

import lk.ijse.libraryManagementSystem.bo.SupplyerBO;
import lk.ijse.libraryManagementSystem.dao.SupplyerDAO;
import lk.ijse.libraryManagementSystem.dto.SupplyerDTO;
import lk.ijse.libraryManagementSystem.entity.Supplier;
import lk.ijse.libraryManagementSystem.util.DAOFactory;

import java.sql.SQLException;

public class SupplyerBOImpl implements SupplyerBO {

    public SupplyerDAO supplyerDAO = (SupplyerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLYER);

    @Override
    public void saveSupplyer(SupplyerDTO dto) throws SQLException, ClassNotFoundException {
        supplyerDAO.save(new Supplier(dto.getsId(),dto.getsName(),dto.getsEmail(),dto.getsNo()));
    }

    @Override
    public void updateSupplyer(SupplyerDTO dto) throws SQLException, ClassNotFoundException {
        supplyerDAO.update(new Supplier(dto.getsId(),dto.getsName(),dto.getsEmail(),dto.getsNo()));
    }

    @Override
    public void deleteSupplyer(String id) throws SQLException, ClassNotFoundException {
        supplyerDAO.delete(id);
    }

    @Override
    public SupplyerDTO searchSupplyer(String id) throws SQLException, ClassNotFoundException {
        Supplier supplier = supplyerDAO.search(id);
        return new SupplyerDTO(
                supplier.getSupplierID(),supplier.getSuppliersName(),supplier.getSuppliersGmail(),supplier.getSuppliersNo());
    }

    @Override
    public String getLastSupplyerId() throws SQLException, ClassNotFoundException {
        return supplyerDAO.generateNewID();
    }
}
