package org.mehmet.inventorymanagementsystem.service.abstr;

import org.mehmet.inventorymanagementsystem.dto.bill.BillCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillResponseDTO;

import java.util.List;

public interface IBillService {

    boolean createBill(BillCreateRequestDTO billCreateRequestDTO);

    List<BillResponseDTO> getAllBills();

    BillResponseDTO getBillById(int id);

    boolean updateBill(BillCreateRequestDTO billCreateRequestDTO);

    boolean deleteBill(int id);
}
