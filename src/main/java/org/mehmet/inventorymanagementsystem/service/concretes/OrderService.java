package org.mehmet.inventorymanagementsystem.service.concretes;

import org.mehmet.inventorymanagementsystem.converter.OrderConverter;
import org.mehmet.inventorymanagementsystem.dao.concretes.OrderDAO;
import org.mehmet.inventorymanagementsystem.dto.order.CreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.order.OrderResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.order.OrderUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.model.Order;
import org.mehmet.inventorymanagementsystem.service.abstr.IOrderService;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService implements IOrderService {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO, OrderConverter orderConverter) {
        this.orderDAO = orderDAO;
    }

    @Override
    public OrderResponseDTO placeOrder(CreateRequestDTO createRequestDTO) {
        Order order = OrderConverter.toEntity(createRequestDTO);
        orderDAO.createOrder(order);
        return OrderConverter.toResponseDTO(order);
    }

    @Override
    public List<OrderResponseDTO> getOrdersBySupplier(int supplierId) {
        List<Order> orders = orderDAO.getOrdersBySupplierId(supplierId);
        return orders.stream().map(OrderConverter::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderResponseDTO> getOrdersByRetailer(int retailerId) {
        List<Order> orders = orderDAO.getOrdersByRetailerId(retailerId);
        return orders.stream().map(OrderConverter::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public OrderResponseDTO updateOrderStatus(OrderUpdateRequestDTO updateRequestDTO) {
        Order order = orderDAO.getOrderById(updateRequestDTO.getOrderId());
        if (order != null) {
            Order updatedOrder = OrderConverter.applyUpdate(order, updateRequestDTO);
            orderDAO.updateOrderStatus(updatedOrder.getId(), updatedOrder.getOrderStatus());
            return OrderConverter.toResponseDTO(updatedOrder);
        }
        throw new IllegalArgumentException("Order not found");
    }

    public List<OrderResponseDTO> getOrdersBySupplierId(int supplierId) {
            return null;
    }
}
