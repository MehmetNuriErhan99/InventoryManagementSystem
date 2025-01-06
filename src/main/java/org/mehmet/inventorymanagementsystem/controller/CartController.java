package org.mehmet.inventorymanagementsystem.controller;

import org.mehmet.inventorymanagementsystem.dto.cart.CartCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.cart.CartResponseDTO;
import org.mehmet.inventorymanagementsystem.service.abstr.ICartService;
import org.mehmet.inventorymanagementsystem.service.concretes.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class CartController extends HttpServlet {

    private ICartService cartService;

    @Override
    public void init() throws ServletException {
        try {
            cartService = new CartService(); // ICartService'i başlatıyoruz
        } catch (Exception e) {
            throw new ServletException("CartService başlatılırken hata: " + e.getMessage(), e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("view".equals(action)) {
                int retailerId = Integer.parseInt(request.getParameter("retailerId"));
                List<CartResponseDTO> cartItems = cartService.getCartByRetailerId(retailerId);
                request.setAttribute("cartItems", cartItems);
                request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action.");
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int retailerId = Integer.parseInt(request.getParameter("retailerId"));
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            CartCreateRequestDTO cartCreateRequestDTO = new CartCreateRequestDTO(retailerId, productId, quantity);
            cartService.addProductToCart(cartCreateRequestDTO);

            response.sendRedirect("/cart?action=view&retailerId=" + retailerId);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
