package org.mehmet.inventorymanagementsystem.controller;

import org.mehmet.inventorymanagementsystem.dao.concretes.BillDAO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillCreateRequestDTO;
import org.mehmet.inventorymanagementsystem.dto.bill.BillResponseDTO;
import org.mehmet.inventorymanagementsystem.service.abstr.IBillService;
import org.mehmet.inventorymanagementsystem.service.concretes.BillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/bills")
public class BillController extends HttpServlet {

    private IBillService billService;

    @Override
    public void init() throws ServletException {
        try {
            billService = new BillService(new BillDAO()); // Correct initialization
        } catch (SQLException e) {
            throw new ServletException("BillService initialization failed", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Controller logic remains the same
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle Bill creation
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle Bill update
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle Bill delete
    }
}
