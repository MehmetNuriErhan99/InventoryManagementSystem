package org.mehmet.inventorymanagementsystem.service.abstr;

import org.mehmet.inventorymanagementsystem.dto.bill.BillCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillUpdateRequestDTO;

import java.util.List;

public interface IBillService {

    BillResponseDTO createBill(BillCreateRequestDTO billCreateRequestDTO);

    List<BillResponseDTO> getAllBills();

    BillResponseDTO getBillById(int id);

    BillResponseDTO updateBill(BillUpdateRequestDTO billUpdateRequestDTO);

    boolean deleteBill(int id);
}
