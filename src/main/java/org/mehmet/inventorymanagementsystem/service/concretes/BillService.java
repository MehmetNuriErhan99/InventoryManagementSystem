package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.dao.abstr.IBillDAO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillResponseDTO;
import org.mehmet.inventorymanagementsystem.converter.BillConverter;
import org.mehmet.inventorymanagementsystem.model.Bill;
import org.mehmet.inventorymanagementsystem.service.abstr.IBillService;

import java.util.List;
import java.util.stream.Collectors;

public class BillService implements IBillService {

    private final IBillDAO billDAO;

    public BillService(IBillDAO billDAO) {
        this.billDAO = billDAO;
    }

    @Override
    public boolean createBill(BillCreateRequestDTO billCreateRequestDTO) {
        Bill bill = BillConverter.toBill(billCreateRequestDTO);
        return billDAO.createBill(bill);
    }

    @Override
    public List<BillResponseDTO> getAllBills() {
        List<Bill> bills = billDAO.getAllBills();
        return bills.stream()
                .map(BillConverter::toBillResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BillResponseDTO getBillById(int id) {
        Bill bill = billDAO.getBillById(id);
        return bill != null ? BillConverter.toBillResponseDTO(bill) : null;
    }

    @Override
    public boolean updateBill(BillCreateRequestDTO billCreateRequestDTO) {
        Bill bill = BillConverter.toBill(billCreateRequestDTO);
        return billDAO.updateBill(bill);
    }

    @Override
    public boolean deleteBill(int id) {
        return billDAO.deleteBill(id);
    }
}
