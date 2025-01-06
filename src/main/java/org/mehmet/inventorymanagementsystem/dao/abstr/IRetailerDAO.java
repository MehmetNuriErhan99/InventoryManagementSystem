package org.mehmet.inventorymanagementsystem.dao.abstr;

import org.mehmet.inventorymanagementsystem.model.Retailer;

public interface IRetailerDAO {
    void registerRetailer(Retailer retailer) throws Exception;
    Retailer loginRetailer(String email, String password) throws Exception;
}
