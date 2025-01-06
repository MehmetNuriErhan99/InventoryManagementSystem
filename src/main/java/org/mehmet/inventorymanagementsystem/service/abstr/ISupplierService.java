package org.mehmet.inventorymanagementsystem.service.abstr;

import org.mehmet.inventorymanagementsystem.dto.user.UserResponseDTO;

import java.util.List;

public interface ISupplierService {
    List<UserResponseDTO> getAllSuppliers() throws Exception;

    void addSupplier(UserResponseDTO supplier) throws Exception;

    void updateSupplier(UserResponseDTO supplier) throws Exception;

    void deleteSupplier(int supplierId) throws Exception;
}
