package com.solvd.jbdc.dao;

import com.solvd.models.CarSale;
import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iCarSaleDAO;

import java.util.List;

public class CarSaleDAO implements iCarSaleDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void saveEntity(CarSale carSale) {

    }

    @Override
    public CarSale getEntityById(int id) {
        return null;
    }

    @Override
    public void updateEntity(CarSale carSale) {

    }

    @Override
    public void removeEntityById(int id) {

    }

    @Override
    public List<CarSale> getCarSalesByEmployeeID(int id) {
        return null;
    }
}
