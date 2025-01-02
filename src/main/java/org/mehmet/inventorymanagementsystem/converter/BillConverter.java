package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.bill.BillCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.model.Bill;

public class BillConverter {


    public static Bill toModel(BillCreateRequestDTO billCreateRequestDTO) {
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


    public static Bill toModel(BillUpdateRequestDTO billUpdateRequestDTO) {
        return new Bill(
                billUpdateRequestDTO.getId(),
                billUpdateRequestDTO.getSupplierId(),
                billUpdateRequestDTO.getRetailerId(),
                billUpdateRequestDTO.getProductId(),
                billUpdateRequestDTO.getAmount(),
                billUpdateRequestDTO.getCurrentPrice(),
                billUpdateRequestDTO.getDate()
        );
    }
    // Bill modelinden BillResponseDTO'ya dönüşüm
    public static BillResponseDTO toResponse(Bill bill) {

        return new BillResponseDTO(
                bill.getId(),
                "SUCCESS",
                "Bill created successfully!"
        );
    }
}
