package com.solvd.services;

import com.solvd.interfaces.iCarTypeDAO;
import com.solvd.jbdc.dao.CarTypeDAO;
import com.solvd.models.CarType;

import java.util.List;

public class CarTypeService implements iCarTypeDAO {

    CarTypeDAO carTypeDAO = new CarTypeDAO();

    @Override
    public void saveEntity(CarType carType) {
        carTypeDAO.saveEntity(carType);
    }

    @Override
    public CarType getEntityById(int id) {
        return carTypeDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(CarType carType) {
        carTypeDAO.updateEntity(carType);
    }

    @Override
    public void removeEntityById(int id) {
        carTypeDAO.removeEntityById(id);
    }

    @Override
    public List<CarType> getAll() {
        return carTypeDAO.getAll();
    }

    @Override
    public CarType getCarTypeByName(String carType) {
        return carTypeDAO.getCarTypeByName(carType);
    }
}
