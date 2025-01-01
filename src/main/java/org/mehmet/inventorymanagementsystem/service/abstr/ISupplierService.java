package org.mehmet.inventorymanagementsystem.service.abstr;




import org.mehmet.inventorymanagementsystem.dto.supplier.SupplierCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.supplier.SupplierResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.supplier.SupplierUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.model.Supplier;

import java.util.List;

public interface ISupplierService {
    SupplierResponseDTO createSupplier(SupplierCreateRequestDTO supplierCreateRequestDTO);

    List<SupplierResponseDTO> getAllSuppliers();

    SupplierResponseDTO getSupplierById(int id);

    SupplierResponseDTO updateSupplier(SupplierUpdateRequestDTO supplierUpdateRequestDTO);

    boolean deleteSupplier(int id);

    boolean createSupplier(Supplier newSupplier);
}
