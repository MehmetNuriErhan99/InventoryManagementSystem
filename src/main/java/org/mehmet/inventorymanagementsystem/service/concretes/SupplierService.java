package org.mehmet.inventorymanagementsystem.service.concretes;


import org.mehmet.inventorymanagementsystem.dao.abstr.ISupplierDAO;
import org.mehmet.inventorymanagementsystem.dto.supplier.SupplierCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.supplier.SupplierResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.supplier.SupplierUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.converter.SupplierConverter;
import org.mehmet.inventorymanagementsystem.model.Supplier;
import org.mehmet.inventorymanagementsystem.service.abstr.ISupplierService;
import org.mehmet.inventorymanagementsystem.exception.BusinessException;
import org.mehmet.inventorymanagementsystem.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierService implements ISupplierService {

    private final ISupplierDAO supplierDAO;


    public SupplierService(ISupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }

    @Override
    public SupplierResponseDTO createSupplier(SupplierCreateRequestDTO supplierCreateRequestDTO) {
        try {
            Supplier supplier = SupplierConverter.toModel(supplierCreateRequestDTO);

            boolean isCreated = supplierDAO.createSupplier(supplier);

            if (!isCreated) {
                throw new BusinessException("Supplier creation failed.");
            }

            return SupplierConverter.toResponse(supplier);
        } catch (Exception e) {
            throw new BusinessException("Error while creating supplier: " + e.getMessage());
        }
    }

    @Override
    public List<SupplierResponseDTO> getAllSuppliers() {
        try {
            List<Supplier> suppliers = supplierDAO.getAllSuppliers();
            if (suppliers.isEmpty()) {
                throw new NotFoundException("No suppliers found.");
            }

            return suppliers.stream()
                    .map(SupplierConverter::toResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new BusinessException("Error while retrieving suppliers: " + e.getMessage());
        }
    }

    @Override
    public SupplierResponseDTO getSupplierById(int id) {
        try {
            Supplier supplier = supplierDAO.getSupplierById(id);
            if (supplier == null) {
                throw new NotFoundException("Supplier not found with ID: " + id);
            }

            return SupplierConverter.toResponse(supplier);
        } catch (NotFoundException e) {
            throw e;  // Hata özel olarak yakalanarak tekrar fırlatılır
        } catch (Exception e) {
            throw new BusinessException("Error while retrieving supplier: " + e.getMessage());
        }
    }

    @Override
    public SupplierResponseDTO updateSupplier(SupplierUpdateRequestDTO supplierUpdateRequestDTO) {
        try {
            Supplier supplier = SupplierConverter.toModel(supplierUpdateRequestDTO);

            boolean isUpdated = supplierDAO.updateSupplier(supplier);

            if (!isUpdated) {
                throw new BusinessException("Supplier update failed.");
            }

            return SupplierConverter.toResponse(supplier);
        } catch (Exception e) {
            throw new BusinessException("Error while updating supplier: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteSupplier(int id) {
        try {
            boolean isDeleted = supplierDAO.deleteSupplier(id);
            if (!isDeleted) {
                throw new NotFoundException("Supplier not found with ID: " + id);
            }
            return true;
        } catch (NotFoundException e) {
            throw e;  // Supplier bulunamazsa özel hata
        } catch (Exception e) {
            throw new BusinessException("Error while deleting supplier: " + e.getMessage());
        }
    }

    @Override
    public boolean createSupplier(Supplier newSupplier) {
        return false;
    }
}
