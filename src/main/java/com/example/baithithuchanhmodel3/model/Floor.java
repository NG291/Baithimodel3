package com.example.baithithuchanhmodel3.model;

import java.sql.Date;

public class Floor {
    public String floorCode;
    public double area;
    public  String status;
    public int floorType;
    public String officeType;
    public String describe;
    public double price;
    public Date startDate;
    public Date endDate;

  public Floor (){}

    public Floor(String floorCode, double area, String status, int floor, String officeType, String describe, double price, Date startDate, Date endDate) {
        this.floorCode = floorCode;
        this.area = area;
        this.status = status;
        this.floorType = floor;
        this.officeType = officeType;
        this.describe = describe;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Floor(String floorCode, double area,String status, int floorType, String officeType, double price, Date startDate,Date endDate) {
        this.floorCode = floorCode;
        this.area = area;
        this.status = status;
        this.floorType = floorType;
        this.officeType = officeType;
        this.price = price;
        this.startDate = startDate;
        this.endDate= endDate;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFloor() {
        return floorType;
    }

    public void setFloor(int floor) {
        this.floorType = floor;
    }

    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorCode='" + floorCode + '\'' +
                ", area=" + area +
                ", status='" + status + '\'' +
                ", floor=" + floorType +
                ", officeType=" + officeType +
                ", describe='" + describe + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
