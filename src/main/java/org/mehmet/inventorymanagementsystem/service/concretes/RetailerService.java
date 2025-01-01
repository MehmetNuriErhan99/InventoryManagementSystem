package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IRetailerDAO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.retailer.RetailerUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.exception.BusinessException;
import org.mehmet.inventorymanagementsystem.exception.NotFoundException;
import org.mehmet.inventorymanagementsystem.model.Retailer;
import org.mehmet.inventorymanagementsystem.service.abstr.IRetailerService;
import org.mehmet.inventorymanagementsystem.converter.RetailerConverter;

import java.util.List;
import java.util.stream.Collectors;

public class RetailerService implements IRetailerService {

    private final IRetailerDAO retailerDAO;

    public RetailerService(IRetailerDAO retailerDAO) {
        this.retailerDAO = retailerDAO;
    }

    @Override
    public RetailerResponseDTO createRetailer(RetailerCreateRequestDTO retailerCreateRequestDTO) {
        try {
            Retailer retailer = RetailerConverter.toModel(retailerCreateRequestDTO, 0); // 'id' burada 0 olarak verildi

            boolean isCreated = retailerDAO.createRetailer(retailer);

            if (isCreated) {
                return RetailerConverter.toResponse(retailer);
            } else {
                throw new BusinessException("Retailer creation failed.");
            }
        } catch (Exception e) {
            throw new BusinessException("Retailer creation failed: " + e.getMessage());
        }
    }

    @Override
    public List<RetailerResponseDTO> getAllRetailers() {
        try {
            List<Retailer> retailers = retailerDAO.getAllRetailers();
            return retailers.stream()
                    .map(RetailerConverter::toResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new BusinessException("Error retrieving retailers: " + e.getMessage());
        }
    }

    @Override
    public RetailerResponseDTO getRetailerById(int id) {
        try {
            Retailer retailer = retailerDAO.getRetailerById(id);
            if (retailer != null) {
                return RetailerConverter.toResponse(retailer);
            } else {
                throw new NotFoundException("Retailer not found for ID: " + id);
            }
        } catch (NotFoundException e) {
            throw e; // Rethrow custom exception
        } catch (Exception e) {
            throw new BusinessException("Error retrieving retailer: " + e.getMessage());
        }
    }

    @Override
    public RetailerResponseDTO updateRetailer(RetailerUpdateRequestDTO retailerUpdateRequestDTO) {
        try {
            Retailer retailer = RetailerConverter.toModel(retailerUpdateRequestDTO);

            boolean isUpdated = retailerDAO.updateRetailer(retailer);

            if (isUpdated) {
                return RetailerConverter.toResponse(retailer);
            } else {
                throw new BusinessException("Retailer update failed.");
            }
        } catch (Exception e) {
            throw new BusinessException("Retailer update failed: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteRetailer(int id) {
        try {
            // Retailer'ı silme
            boolean isDeleted = retailerDAO.deleteRetailer(id);
            if (isDeleted) {
                return true;
            } else {
                throw new NotFoundException("Retailer not found for ID: " + id);
            }
        } catch (NotFoundException e) {
            throw e; // Rethrow custom exception
        } catch (Exception e) {
            throw new BusinessException("Error deleting retailer: " + e.getMessage());
        }
    }
}
