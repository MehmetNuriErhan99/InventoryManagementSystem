package org.mehmet.inventorymanagementsystem.converter;


import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.model.Retailer;
public class RetailerConverter {

    // RetailerCreateRequestDTO'dan Retailer modeline dönüşüm
    public static Retailer toModel(RetailerCreateRequestDTO retailerCreateRequestDTO, int id) {
        return new Retailer(
                id, // ID parametreyi dışarıdan alıyoruz
                retailerCreateRequestDTO.getName(),
                retailerCreateRequestDTO.getPhoneNumber(),
                retailerCreateRequestDTO.getEmailAddress(),
                retailerCreateRequestDTO.getPassword(),
                retailerCreateRequestDTO.getPhoto()
        );
    }

    // RetailerUpdateRequestDTO'dan Retailer modeline dönüşüm
    public static Retailer toModel(RetailerUpdateRequestDTO retailerUpdateRequestDTO) {
        return new Retailer(
                retailerUpdateRequestDTO.getId(),
                retailerUpdateRequestDTO.getName(),
                retailerUpdateRequestDTO.getPhoneNumber(),
                retailerUpdateRequestDTO.getEmailAddress(),
                retailerUpdateRequestDTO.getPassword(),
                retailerUpdateRequestDTO.getPhoto()
        );
    }

    // Retailer modelinden RetailerResponseDTO'ya dönüşüm
    public static RetailerResponseDTO toResponse(Retailer retailer) {
        return new RetailerResponseDTO(
                retailer.getId(),
                retailer.getName(),
                retailer.getEmailAddress(),
                "SUCCESS" // Örneğin durum başarılı bir işlemde her zaman "SUCCESS" dönebilir.
        );
    }
}
