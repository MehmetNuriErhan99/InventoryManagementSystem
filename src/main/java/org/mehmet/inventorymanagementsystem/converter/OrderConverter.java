package org.mehmet.inventorymanagementsystem.converter;

import org.mehmet.inventorymanagementsystem.dto.order.CreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.order.OrderResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.order.OrderUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.model.Order;

import java.time.LocalDateTime;

public class OrderConverter {

    public static Order toEntity(CreateRequestDTO dto) {
        Order order = new Order();
        order.setSupplierId(dto.getSupplierId());
        order.setRetailerId(dto.getRetailerId());
        order.setProductId(dto.getProductId());
        order.setAmount(dto.getAmount());
        order.setOrderStatus("Pending"); // Default status for new orders
        order.setCreatedAt(LocalDateTime.now()); // Set current time as createdAt
        return order;
    }

    public static OrderResponseDTO toResponseDTO(Order order) {
        return new OrderResponseDTO(
                order.getId(),
                order.getSupplierId(),
                order.getRetailerId(),
                order.getProductId(),
                order.getAmount(),
                order.getOrderStatus(),
                order.getCreatedAt()
        );
    }

    public static Order applyUpdate(Order order, OrderUpdateRequestDTO dto) {
        order.setOrderStatus(dto.getOrderStatus());
        return order;
    }
}
