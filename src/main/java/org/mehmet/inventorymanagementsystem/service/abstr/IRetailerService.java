package org.mehmet.inventorymanagementsystem.service.abstr;



import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerUpdateRequestDTO;

import java.util.List;

public interface IRetailerService {

    RetailerResponseDTO createRetailer(RetailerCreateRequestDTO retailerCreateRequestDTO);

    List<RetailerResponseDTO> getAllRetailers();

    RetailerResponseDTO getRetailerById(int id);

    RetailerResponseDTO updateRetailer(RetailerUpdateRequestDTO retailerUpdateRequestDTO);

    boolean deleteRetailer(int id);
}
