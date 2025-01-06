package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.supplier.*;
import org.mehmet.inventorymanagementsystem.model.Supplier;

public class SupplierConverter {

    public SupplierResponseDTO toResponseDTO(Supplier supplier) {
        return new SupplierResponseDTO(
                supplier.getId(),
                supplier.getName(),
                supplier.getEmailAddress(),
                supplier.getPhoneNumber(),
                supplier.getPhoto()
        );
    }

    public SupplierOrderResponseDTO toOrderResponseDTO(Supplier supplier, int productId, int stockAmount) {
        return new SupplierOrderResponseDTO(
                supplier.getId(),
                supplier.getName(),
                productId,
                stockAmount
        );
    }

    public Supplier toEntity(SupplierStockUpdateDTO dto) {
        return new Supplier(
                dto.getSupplierId(),
                null, // Name is not updated in stock updates
                null, // Email is not updated in stock updates
                null, // PhoneNumber is not updated in stock updates
                null // Photo is not updated in stock updates
        );
    }

    public SupplierStockUpdateDTO toStockUpdateDTO(Supplier supplier, int stockAmount) {
        return new SupplierStockUpdateDTO(
                supplier.getId(),
                stockAmount
        );
    }

    public Supplier toEntity(SupplierResponseDTO dto) {
        return new Supplier(
                dto.getId(),
                dto.getName(),
                dto.getEmailAddress(),
                dto.getPhoneNumber(),
                dto.getPhoto()
        );
    }
}
