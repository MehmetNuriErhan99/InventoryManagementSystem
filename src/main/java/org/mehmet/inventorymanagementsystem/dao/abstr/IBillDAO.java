package org.mehmet.inventorymanagementsystem.dao.abstr;

import org.mehmet.inventorymanagementsystem.model.Bill;
import java.util.List;

public interface IBillDAO {

    boolean createBill(Bill bill);
    List<Bill> getAllBills();
    Bill getBillById(int id);

    boolean updateBill(Bill bill);
    boolean deleteBill(int id);
}
