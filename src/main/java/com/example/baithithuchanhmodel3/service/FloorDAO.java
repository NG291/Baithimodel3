package com.example.baithithuchanhmodel3.service;

import com.example.baithithuchanhmodel3.model.Floor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FloorDAO implements IFloorDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/Floors";
    private String jdbcUsername = "root";
    private String jdbcPassword = "012345";
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println("ket noi that bai");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("ket noi that bai");
            throw new RuntimeException(e);
        }
        return connection;
    }
    @Override
    public List<Floor> getALLFloor() {
        String selectFloor = "SELECT MaMB, DienTich, TrangThai, Tang, LoaiVanPhong, GiaChoThue, NgayBatDau, NgayKetThuc FROM Floor ORDER BY DienTich ASC;;";
        List<Floor> floors = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement= connection.prepareStatement(selectFloor)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String floorCode=rs.getString("MaMB");
                double area= Double.parseDouble(rs.getString("DienTich"));
                String status = rs.getString("TrangThai");
                int floorType = Integer.parseInt(rs.getString("Tang"));
                String officeType= rs.getString("LoaiVanPhong");
                double price = Double.parseDouble(rs.getString("GiaChoThue"));
                Date startDate = rs.getDate("NgayBatDau");
                Date endDate = rs.getDate("NgayKetThuc");
                floors.add(new Floor(floorCode,area,status,floorType,officeType,price,startDate,endDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return floors;
    }


    @Override
    public void createFloor(Floor floor) {
        String insert ="INSERT INTO Floor (MaMB, DienTich, TrangThai, Tang, LoaiVanPhong,MoTa ,GiaChoThue, NgayBatDau, NgayKetThuc) VALUES (?,?, ?,?,?,?,?,?,)";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement= connection.prepareStatement(insert)) {
            preparedStatement.setString(1,floor.floorCode);
            preparedStatement.setDouble(2,floor.area);
            preparedStatement.setString(3,floor.status);
            preparedStatement.setInt(4,floor.floorType);
            preparedStatement.setString(5,floor.officeType);
            preparedStatement.setString(6,floor.describe);
            preparedStatement.setDouble(7,floor.price);
            preparedStatement.setDate(8,floor.startDate);
            preparedStatement.setDate(9,floor.endDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteFloor(String floorCore) {
        String delete = "DELETE FROM products WHERE id=?";
        boolean rowDelete;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

    @Override
    public Floor findById(String floorCore) {
        return null;
    }

    @Override
    public List<Floor> FindBYFloorType(String floorType) {
        return Collections.emptyList();
    }

    @Override
    public List<Floor> FindByPrice(int price) {
        return Collections.emptyList();
    }
}
