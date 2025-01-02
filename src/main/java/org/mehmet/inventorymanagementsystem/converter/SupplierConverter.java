package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.supplier.SupplierCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.supplier.SupplierResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.supplier.SupplierUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.model.Supplier;

public class SupplierConverter {

    public static Supplier toModel(SupplierCreateRequestDTO dto) {
        return new Supplier(
                dto.getName(),
                dto.getPhoneNumber(),
                dto.getEmailAddress(),
                dto.getPassword(),
                dto.getPhoto()
        );
    }

    public static Supplier toModel(SupplierUpdateRequestDTO dto) {
        return new Supplier(
                dto.getId(),
                dto.getName(),
                dto.getPhoneNumber(),
                dto.getEmailAddress(),
                dto.getPassword(),
                dto.getPhoto()
        );
    }

    public static SupplierResponseDTO toResponse(Supplier supplier) {
        String status = supplier != null ? "SUCCESS" : "FAILURE";
        String message = supplier != null ? "Supplier successfully processed" : "Failed to process supplier";
        return new SupplierResponseDTO(supplier.getId(), status, message);
    }
}

