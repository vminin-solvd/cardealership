package com.solvd.services;

import com.solvd.interfaces.iPositionDAO;
import com.solvd.jbdc.dao.PositionDAO;
import com.solvd.models.Position;

import java.util.List;

public class PositionService implements iPositionDAO {

    PositionDAO positionDAO = new PositionDAO();

    @Override
    public void saveEntity(Position position) {
        positionDAO.saveEntity(position);
    }

    @Override
    public Position getEntityById(int id) {
        return positionDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(Position position) {
        positionDAO.updateEntity(position);
    }

    @Override
    public void removeEntityById(int id) {
        positionDAO.removeEntityById(id);
    }

    @Override
    public List<Position> getAll() {
        return positionDAO.getAll();
    }

    @Override
    public Position getPositionByName(String positionName) {
        return positionDAO.getPositionByName(positionName);
    }
}
