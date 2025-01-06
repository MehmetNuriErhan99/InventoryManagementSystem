package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.converter.RetailerConverter;
import org.mehmet.inventorymanagementsystem.dao.abstr.IRetailerDAO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerLoginDTO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerRegisterDTO;
import org.mehmet.inventorymanagementsystem.model.Retailer;
import org.mehmet.inventorymanagementsystem.service.abstr.IRetailerService;

public class RetailerService implements IRetailerService {
    private final IRetailerDAO retailerDAO;
    private final RetailerConverter retailerConverter;

    public RetailerService(IRetailerDAO retailerDAO, RetailerConverter retailerConverter) {
        this.retailerDAO = retailerDAO;
        this.retailerConverter = retailerConverter;
    }

    @Override
    public void registerRetailer(RetailerRegisterDTO dto) throws Exception {
        Retailer retailer = retailerConverter.toEntity(dto);
        retailerDAO.registerRetailer(retailer);
    }

    @Override
    public boolean loginRetailer(RetailerLoginDTO dto) throws Exception {
        Retailer retailer = retailerDAO.loginRetailer(dto.getEmailAddress(), dto.getPassword());
        return retailer != null;
    }
}
