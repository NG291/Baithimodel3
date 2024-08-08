package com.example.baithithuchanhmodel3.controller;

import com.example.baithithuchanhmodel3.model.Floor;
import com.example.baithithuchanhmodel3.service.FloorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "FloorServlet", urlPatterns = "/floors")
public class FloorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        try {
            switch (action) {
                case "create":
                    showFormInsert(req, resp);
                    break;
                case "delete":
                    deleteProduct(req, resp);
                    break;
                default:
                    FloorDAO floorDAO = new FloorDAO();
                    List<Floor> floors = floorDAO.getALLFloor();
                    System.out.println(floors);
                    req.setAttribute("floors", floors);
                    req.getRequestDispatcher("/floor/list.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void showFormInsert(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, SQLException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/floors/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                insertFloor(req, resp);
                break;
            case "update":
        }

    }

    private void insertFloor(HttpServletRequest req, HttpServletResponse resp) {
        FloorDAO floorDAO = new FloorDAO();
        String floorCode  = req.getParameter("maMB");
        double area = Double.parseDouble(req.getParameter("dienTich"));
        String status = req.getParameter("trangThai");
        int floorType = Integer.parseInt(req.getParameter("tang"));
        String officeType = req.getParameter("loaiVanPhong");
        String describe = req.getParameter("MoTa");
        double price = Double.parseDouble(req.getParameter("giaChoThue"));
        Date startDate = Date.valueOf(req.getParameter("ngayBatDau"));
        Date endDate = Date.valueOf(req.getParameter("ngayKetThuc"));
        Floor floor = new Floor(floorCode,area,status,floorType,officeType,describe,price,startDate,endDate);
        floorDAO.createFloor(floor);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/floor/create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
