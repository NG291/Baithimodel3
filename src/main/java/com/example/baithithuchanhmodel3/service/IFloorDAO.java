package com.example.baithithuchanhmodel3.service;

import com.example.baithithuchanhmodel3.model.Floor;

import java.util.List;

public interface IFloorDAO {
    List<Floor> getALLFloor();
    public void createFloor(Floor floor);
    public boolean deleteFloor(String floorCore);
    public  Floor findById(String floorCore);
    public List<Floor>  FindBYFloorType(String floorType);
    public List<Floor> FindByPrice(int price);

}
