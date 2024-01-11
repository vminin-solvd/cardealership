package com.solvd.services;

import com.solvd.interfaces.ICarSaleDAO;
import com.solvd.mybatis.dao.CarSaleDAO;
import com.solvd.models.CarSale;
import java.util.List;

public class CarSaleService implements ICarSaleDAO {

    private CarSaleDAO carSaleDAO = new CarSaleDAO();

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
