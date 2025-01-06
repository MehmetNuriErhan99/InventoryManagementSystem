package org.mehmet.inventorymanagementsystem.controller;

import org.mehmet.inventorymanagementsystem.dao.concretes.SupplierDAO;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import org.mehmet.inventorymanagementsystem.model.Order;
import org.mehmet.inventorymanagementsystem.model.User;
import org.mehmet.inventorymanagementsystem.service.concretes.SupplierService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/suppliers")
public class SupplierController extends HttpServlet {

    private SupplierService supplierService;

    @Override
    public void init() throws ServletException {
        SupplierDAO supplierDAO = new SupplierDAO(DatabaseConnection.getConnection());
        supplierService = new SupplierService(supplierDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !"Supplier".equals(session.getAttribute("role"))) {
            resp.sendRedirect(req.getContextPath() + "/user_login.jsp");
            return;
        }

        String action = req.getParameter("action");

        try {
            if ("list".equals(action)) {
                List<User> suppliers = supplierService.getAllSuppliers();
                req.setAttribute("suppliers", suppliers);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/supplier_list.jsp");
                dispatcher.forward(req, resp);
            } else if ("orders".equals(action)) {
                int supplierId = Integer.parseInt(session.getAttribute("userId").toString());
                List<Order> orders = supplierService.getSupplierOrders(supplierId);
                req.setAttribute("orders", orders);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/supplier_orders.jsp");
                dispatcher.forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action not recognized.");
            }
        } catch (Exception e) {
            throw new ServletException("Error processing GET request in SupplierController", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        if ("approve".equals(action)) {
        } else if ("reject".equals(action)) {
        }

        response.sendRedirect(request.getContextPath() + "/order_list.jsp");
    }
}
