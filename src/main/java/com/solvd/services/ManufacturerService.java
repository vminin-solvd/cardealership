package com.solvd.services;

import com.solvd.interfaces.IManufacturerDAO;
import com.solvd.jbdc.dao.ManufacturerDAO;
import com.solvd.models.Manufacturer;

import java.util.List;

public class ManufacturerService implements IManufacturerDAO {

    ManufacturerDAO manufacturerDAO = new ManufacturerDAO();

    @Override
    public void saveEntity(Manufacturer manufacturer) {
        manufacturerDAO.saveEntity(manufacturer);
    }

    @Override
    public Manufacturer getEntityById(int id) {
        return manufacturerDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(Manufacturer manufacturer) {
        manufacturerDAO.updateEntity(manufacturer);
    }

    @Override
    public void removeEntityById(int id) {
        manufacturerDAO.removeEntityById(id);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDAO.getAll();
    }

    @Override
    public Manufacturer getManufacturerByName(String manufacturerName) {
        return manufacturerDAO.getManufacturerByName(manufacturerName);
    }
}
