package org.mehmet.inventorymanagementsystem.controller;

import org.mehmet.inventorymanagementsystem.converter.OrderConverter;
import org.mehmet.inventorymanagementsystem.dao.concretes.OrderDAO;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import org.mehmet.inventorymanagementsystem.dto.order.OrderResponseDTO;
import org.mehmet.inventorymanagementsystem.service.concretes.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrderController extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderService = new OrderService(
                new OrderDAO(DatabaseConnection.getConnection()),
                new OrderConverter()
        );
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);


        if (session == null || !"Supplier".equals(session.getAttribute("role"))) {
            resp.sendRedirect(req.getContextPath() + "/user_login.jsp");
            return;
        }

        int supplierId = (int) session.getAttribute("userId"); // Supplier ID oturumdan alınıyor.
        try {
            List<OrderResponseDTO> orders = orderService.getOrdersBySupplierId(supplierId);
            if (orders == null || orders.isEmpty()) {
                req.setAttribute("errorMessage", "Sipariş bulunamadı.");
            } else {
                req.setAttribute("orders", orders);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/supplier_orders.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Siparişler alınırken bir hata oluştu.", e);
        }
    }
}
