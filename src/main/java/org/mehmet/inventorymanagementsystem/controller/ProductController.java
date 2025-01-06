package org.mehmet.inventorymanagementsystem.controller;

import org.mehmet.inventorymanagementsystem.converter.ProductConverter;
import org.mehmet.inventorymanagementsystem.dao.concretes.ProductDAO;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import org.mehmet.inventorymanagementsystem.dto.product.ProductCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductResponseDTO;
import org.mehmet.inventorymanagementsystem.dto.product.ProductUpdateRequestDTO;
import org.mehmet.inventorymanagementsystem.service.abstr.IProductService;
import org.mehmet.inventorymanagementsystem.service.concretes.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {

    private IProductService productService;

    @Override
    public void init() throws ServletException {
        try {
            // Veritabanı bağlantısı sağlanır ve servise geçilir
            Connection connection = DatabaseConnection.getConnection();
            productService = new ProductService(new ProductDAO(connection), new ProductConverter());
        } catch (Exception e) {
            throw new ServletException("ProductService initialization failed.", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userRole") == null) {
            resp.sendRedirect(req.getContextPath() + "/user_login.jsp");
            return;
        }

        String action = req.getParameter("action");
        try {
            if ("search".equals(action)) {
                String nameParam = req.getParameter("name");
                if (nameParam != null && !nameParam.isEmpty()) {
                    List<ProductResponseDTO> products = productService.getProductsByName(nameParam);
                    req.setAttribute("products", products);
                }
            } else if ("getAll".equals(action)) {
                List<ProductResponseDTO> products = productService.getAllProducts();
                req.setAttribute("products", products);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/product_index.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Hata oluştu.", e);
        }
    }

    // POST isteği ile ürün ekleme, güncelleme ve silme işlemleri yapılır
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession(false);
        String role = (session != null) ? (String) session.getAttribute("userRole") : null;

        if (role == null) {
            resp.sendRedirect(req.getContextPath() + "/user_login.jsp");
            return;
        }

        String action = req.getParameter("action");

        try {
            if ("create".equals(action) && "Retailer".equals(role)) {
                // Yeni ürün oluşturma
                ProductCreateRequestDTO dto = new ProductCreateRequestDTO(
                        req.getParameter("name"),
                        Integer.parseInt(req.getParameter("stockQuantity")),
                        Double.parseDouble(req.getParameter("price")),
                        Double.parseDouble(req.getParameter("discount"))
                );
                productService.createProduct(dto);
                resp.sendRedirect(req.getContextPath() + "/products");
            } else if ("update".equals(action) && "Retailer".equals(role)) {
                // Ürün güncelleme
                ProductUpdateRequestDTO dto = new ProductUpdateRequestDTO(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        Integer.parseInt(req.getParameter("stockQuantity")),
                        Double.parseDouble(req.getParameter("price")),
                        Double.parseDouble(req.getParameter("discount"))
                );
                productService.updateProduct(dto);
                resp.sendRedirect(req.getContextPath() + "/products");
            } else if ("delete".equals(action) && "Retailer".equals(role)) {
                // Ürün silme
                int id = Integer.parseInt(req.getParameter("id"));
                productService.deleteProduct(id);
                resp.sendRedirect(req.getContextPath() + "/products");
            } else {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Bu işlem için yetkiniz yok.");
            }
        } catch (Exception e) {
            throw new ServletException("Error while processing product action.", e);
        }
    }
}
