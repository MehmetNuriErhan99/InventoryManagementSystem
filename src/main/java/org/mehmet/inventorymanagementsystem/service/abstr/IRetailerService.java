package org.mehmet.inventorymanagementsystem.service.abstr;

import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerLoginDTO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerRegisterDTO;

public interface IRetailerService {
    void registerRetailer(RetailerRegisterDTO dto) throws Exception;
    boolean loginRetailer(RetailerLoginDTO dto) throws Exception;
}
