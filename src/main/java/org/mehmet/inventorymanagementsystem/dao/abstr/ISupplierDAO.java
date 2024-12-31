package org.mehmet.inventorymanagementsystem.dao.abstr;


import org.mehmet.inventorymanagementsystem.model.Supplier;
import java.util.List;

public interface ISupplierDAO {
    boolean createSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(int id);
    boolean updateSupplier(Supplier supplier);
    boolean deleteSupplier(int id);
}
