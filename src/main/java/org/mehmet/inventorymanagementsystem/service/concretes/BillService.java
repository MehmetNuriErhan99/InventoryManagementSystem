package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IBillDAO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.converter.BillConverter;
import org.mehmet.inventorymanagementsystem.model.Bill;
import org.mehmet.inventorymanagementsystem.service.abstr.IBillService;
import org.mehmet.inventorymanagementsystem.exception.BusinessException;
import org.mehmet.inventorymanagementsystem.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class BillService implements IBillService {

    private final IBillDAO billDAO;

    public BillService(IBillDAO billDAO) {
        this.billDAO = billDAO;
    }

    @Override
    public BillResponseDTO createBill(BillCreateRequestDTO billCreateRequestDTO) {
        Bill bill = BillConverter.toModel(billCreateRequestDTO);  // DTO'yu modele dönüştür

        // Veritabanında oluşturulma işlemi
        boolean isCreated = billDAO.createBill(bill);

        if (isCreated) {
            // Başarıyla oluşturulmuşsa, geri döndür
            return new BillResponseDTO(bill.getId(), "SUCCESS", "Bill created successfully");
        } else {
            throw new BusinessException("Failed to create bill.");
        }
    }

    @Override
    public List<BillResponseDTO> getAllBills() {
        List<Bill> bills = billDAO.getAllBills();

        return bills.stream()
                .map(BillConverter::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BillResponseDTO getBillById(int id) {
        Bill bill = billDAO.getBillById(id);

        if (bill == null) {
            throw new NotFoundException("Fatura bulunamadı.");
        }
        return BillConverter.toResponse(bill);
    }

    @Override
    public BillResponseDTO updateBill(BillUpdateRequestDTO billUpdateRequestDTO) {
        Bill bill = BillConverter.toModel(billUpdateRequestDTO);

        boolean isUpdated = billDAO.updateBill(bill);

        return isUpdated ? BillConverter.toResponse(bill) : null;
    }

    @Override
    public boolean deleteBill(int id) {
        boolean isDeleted = billDAO.deleteBill(id);

        if (!isDeleted) {
            throw new NotFoundException("Fatura silinemedi, fatura bulunamadı.");
        }
        return isDeleted;
    }
}
