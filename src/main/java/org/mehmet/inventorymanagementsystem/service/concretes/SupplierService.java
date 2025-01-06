package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.dao.concretes.SupplierDAO;
import org.mehmet.inventorymanagementsystem.model.User;
import org.mehmet.inventorymanagementsystem.model.Order;

import java.sql.SQLException;
import java.util.List;

public class SupplierService {

    private final SupplierDAO supplierDAO;

    public SupplierService(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }


    public List<User> getAllSuppliers() throws SQLException {
        return supplierDAO.getAllSuppliers();
    }


    public void addSupplier(User supplier) throws SQLException {
        supplierDAO.addSupplier(supplier);
    }


    public void updateSupplier(User supplier) throws SQLException {
        supplierDAO.updateSupplier(supplier);
    }


    public void deleteSupplier(int supplierId) throws SQLException {
        supplierDAO.deleteSupplier(supplierId);
    }


    public List<Order> getSupplierOrders(int supplierId) throws SQLException {
        return supplierDAO.getSupplierOrders(supplierId);
    }

    public void updateOrderStatus(int orderId, String newStatus) throws SQLException {
        supplierDAO.updateOrderStatus(orderId, newStatus);
    }
}
