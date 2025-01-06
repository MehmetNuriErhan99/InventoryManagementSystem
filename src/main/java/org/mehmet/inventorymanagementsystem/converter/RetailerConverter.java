package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerRegisterDTO;
import org.mehmet.inventorymanagementsystem.model.Retailer;

public class RetailerConverter {

    public Retailer toEntity(RetailerRegisterDTO dto) {
        return new Retailer(
                0, // Retailer ID (otomatik artacak, bu yüzden 0 bırakılıyor)
                dto.getName(),
                dto.getPhoneNumber(),
                dto.getEmailAddress(),
                dto.getPassword(),
                dto.getPhoto()
        );
    }

}
