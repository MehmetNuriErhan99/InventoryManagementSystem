package org.mehmet.inventorymanagementsystem.dao.abstr;



import org.mehmet.inventorymanagementsystem.model.Retailer;
import java.util.List;

public interface IRetailerDAO {
    boolean createRetailer(Retailer retailer);
    List<Retailer> getAllRetailers();
    Retailer getRetailerById(int id);
    boolean updateRetailer(Retailer retailer);
    boolean deleteRetailer(int id);
}
