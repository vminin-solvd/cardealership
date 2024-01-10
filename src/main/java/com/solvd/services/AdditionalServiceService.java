package com.solvd.services;

import com.solvd.interfaces.IAdditionalServiceDAO;
import com.solvd.mybatis.dao.AdditionalServiceDAO;
import com.solvd.models.AdditionalService;
import java.util.List;

public class AdditionalServiceService implements IAdditionalServiceDAO {

    private AdditionalServiceDAO additionalServiceDAO = new AdditionalServiceDAO();

    @Override
    public AdditionalService getAdditionalServiceByServiceName(String serviceName) {
        return additionalServiceDAO.getAdditionalServiceByServiceName(serviceName);
    }

    @Override
    public void saveEntity(AdditionalService additionalService) {
        additionalServiceDAO.saveEntity(additionalService);
    }

    @Override
    public AdditionalService getEntityById(int id) {
        return additionalServiceDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(AdditionalService additionalService) {
        additionalServiceDAO.updateEntity(additionalService);
    }

    @Override
    public void removeEntityById(int id) {
        additionalServiceDAO.removeEntityById(id);
    }

    @Override
    public List<AdditionalService> getAll() {
        return additionalServiceDAO.getAll();
    }
}

