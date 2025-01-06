package org.mehmet.inventorymanagementsystem.service.abstr;

import org.mehmet.inventorymanagementsystem.dto.order.CreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.order.OrderResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.order.OrderUpdateRequestDTO;

import java.util.List;

public interface IOrderService {
    OrderResponseDTO placeOrder(CreateRequestDTO createRequestDTO);
    List<OrderResponseDTO> getOrdersBySupplier(int supplierId);
    List<OrderResponseDTO> getOrdersByRetailer(int retailerId);
    OrderResponseDTO updateOrderStatus(OrderUpdateRequestDTO updateRequestDTO);
}