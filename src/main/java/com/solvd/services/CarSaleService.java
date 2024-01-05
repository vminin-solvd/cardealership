package com.solvd.services;

import com.solvd.interfaces.iCarSaleDAO;
import com.solvd.jbdc.dao.CarSaleDAO;
import com.solvd.models.CarSale;

import java.util.List;

public class CarSaleService implements iCarSaleDAO {

    CarSaleDAO carSaleDAO = new CarSaleDAO();

    @Override
    public void saveEntity(CarSale carSale) {
        carSaleDAO.saveEntity(carSale);
    }

    @Override
    public CarSale getEntityById(int id) {
        return carSaleDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(CarSale carSale) {
        carSaleDAO.updateEntity(carSale);
    }

    @Override
    public void removeEntityById(int id) {
        carSaleDAO.removeEntityById(id);
    }

    @Override
    public List<CarSale> getAll() {
        return carSaleDAO.getAll();
    }

    @Override
    public List<CarSale> getCarSalesByEmployeeID(int id) {
        return carSaleDAO.getCarSalesByEmployeeID(id);
    }
}
