package com.solvd.jbdc.dao;

import com.solvd.util.ConnectionPool;
import com.solvd.interfaces.iCarDAO;

import java.util.List;

public class CarDAO implements iCarDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();


    @Override
    public void saveEntity(Object o) {

    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getEntityById(int id) {
        return null;
    }

    @Override
    public void updateEntity(Object o) {

    }

    @Override
    public void removeEntityById(int id) {

    }
}
