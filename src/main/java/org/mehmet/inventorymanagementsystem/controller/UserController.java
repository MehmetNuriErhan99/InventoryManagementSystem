package org.mehmet.inventorymanagementsystem.controller;

import org.mehmet.inventorymanagementsystem.converter.UserConverter;
import org.mehmet.inventorymanagementsystem.dao.concretes.UserDAO;
import org.mehmet.inventorymanagementsystem.database.DatabaseConnection;
import org.mehmet.inventorymanagementsystem.dto.user.UserLoginDTO;
import org.mehmet.inventorymanagementsystem.dto.user.UserRegisterDTO;
import org.mehmet.inventorymanagementsystem.dto.user.UserResponseDTO;
import org.mehmet.inventorymanagementsystem.service.concretes.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/users")
public class UserController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService(new UserDAO(DatabaseConnection.getConnection()), new UserConverter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("register".equals(action)) {
                UserRegisterDTO userRegisterDTO = new UserRegisterDTO(
                        req.getParameter("name"),
                        req.getParameter("email"),
                        req.getParameter("password"),
                        req.getParameter("role"),
                        req.getParameter("phoneNumber"),
                        req.getParameter("photo")
                );
                userService.registerUser(userRegisterDTO);
                resp.sendRedirect(req.getContextPath() + "/user_login.jsp");
            } else if ("login".equals(action)) {
                String email = req.getParameter("email");
                String password = req.getParameter("password");

                UserResponseDTO user = userService.loginUser(new UserLoginDTO(email, password));
                if (user != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("loggedUser", user);
                    session.setAttribute("role", user.getRole());
                    session.setAttribute("userId", user.getId());

                    // Yönlendirme
                    if ("Retailer".equals(user.getRole())) {
                        resp.sendRedirect(req.getContextPath() + "/dashboard.jsp");
                    } else if ("Supplier".equals(user.getRole())) {
                        resp.sendRedirect(req.getContextPath() + "/dashboard.jsp");
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/user_login.jsp");
                    }
                } else {
                    req.setAttribute("errorMessage", "Invalid email or password");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/user_login.jsp");
                    dispatcher.forward(req, resp);
                }
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (Exception e) {
            throw new ServletException("Error processing POST request in UserController", e);
        }
    }
}
