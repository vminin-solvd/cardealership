package com.solvd.services;

import com.solvd.interfaces.ICarDAO;
import com.solvd.mybatis.dao.CarDAO;
import com.solvd.models.Car;

import java.util.List;

public class CarService implements ICarDAO {

    private CarDAO carDAO = new CarDAO();

    @Override
    public void saveEntity(Car car) {
        carDAO.saveEntity(car);
    }

    @Override
    public Car getEntityById(int id) {
        return carDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(Car car) {
        carDAO.updateEntity(car);
    }

    @Override
    public void removeEntityById(int id) {
        carDAO.removeEntityById(id);
    }

    @Override
    public List<Car> getAll() {
        return carDAO.getAll();
    }

    @Override
    public List<Car> getCarsByModel(String model) {
        return carDAO.getCarsByModel(model);
    }
}
