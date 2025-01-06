package org.mehmet.inventorymanagementsystem.dao.abstr;

import org.mehmet.inventorymanagementsystem.model.Supplier;

import java.util.List;

public interface ISupplierDAO {
    void createSupplier(Supplier supplier) throws Exception;
    Supplier getSupplierById(int id) throws Exception;
    List<Supplier> getAllSuppliers() throws Exception;
    void updateSupplier(Supplier supplier) throws Exception;
    void deleteSupplier(int id) throws Exception;
}
