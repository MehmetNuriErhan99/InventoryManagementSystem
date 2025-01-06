package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.bill.BillCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillResponseDTO;
import org.mehmet.inventorymanagementsystem.model.Bill;

import java.util.Date;

public class BillConverter {

    public static Bill toBill(BillCreateRequestDTO billCreateRequestDTO) {
        return new Bill(
                billCreateRequestDTO.getId(),
                billCreateRequestDTO.getSupplierId(),
                billCreateRequestDTO.getRetailerId(),
                billCreateRequestDTO.getProductId(),
                billCreateRequestDTO.getAmount(),
                billCreateRequestDTO.getCurrentPrice(),
                billCreateRequestDTO.getDate()
        );
    }

    public static BillResponseDTO toBillResponseDTO(Bill bill) {
        return new BillResponseDTO(
                bill.getId(),
                bill.getSupplierId(),
                bill.getRetailerId(),
                bill.getProductId(),
                bill.getAmount(),
                bill.getCurrentPrice(),
                bill.getDate()
        );
    }
}
