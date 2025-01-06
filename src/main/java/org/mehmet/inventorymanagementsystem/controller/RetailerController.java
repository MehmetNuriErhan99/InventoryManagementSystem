package org.mehmet.inventorymanagementsystem.controller;

import org.mehmet.inventorymanagementsystem.converter.ProductConverter;
import org.mehmet.inventorymanagementsystem.dao.concretes.ProductDAO;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import org.mehmet.inventorymanagementsystem.dto.product.ProductResponseDTO;
import org.mehmet.inventorymanagementsystem.service.concretes.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/retailer/products")
public class RetailerController extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService(new ProductDAO(DatabaseConnection.getConnection()), new ProductConverter());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null || !"Retailer".equals(session.getAttribute("role"))) {
            resp.sendRedirect(req.getContextPath() + "/user_login.jsp");
            return;
        }

        String searchParam = req.getParameter("search");
        try {
            List<ProductResponseDTO> products;

            if (searchParam != null && !searchParam.isEmpty()) {
                products = productService.getProductsByName(searchParam);
            } else {
                products = productService.getAllProducts();
            }

            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/retailer_product_list.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Error while retrieving product list", e);
        }
    }
}
