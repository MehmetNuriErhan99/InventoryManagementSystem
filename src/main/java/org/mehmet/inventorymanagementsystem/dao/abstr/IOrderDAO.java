package org.mehmet.inventorymanagementsystem.dao.abstr;

import org.mehmet.inventorymanagementsystem.model.Order;

import java.util.List;

public interface IOrderDAO {
    void createOrder(Order order);
    Order getOrderById(int id);
    List<Order> getOrdersBySupplierId(int supplierId);
    List<Order> getOrdersByRetailerId(int retailerId);
    void updateOrderStatus(int id, String status);
    void deleteOrder(int id);
}
