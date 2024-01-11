package com.solvd.services;

import com.solvd.interfaces.IServiceTypeDAO;
import com.solvd.mybatis.dao.ServiceTypeDAO;
import com.solvd.models.ServiceType;

import java.util.List;

public class ServiceTypeService implements IServiceTypeDAO {

    private ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAO();

    @Override
    public void saveEntity(ServiceType serviceType) {
        serviceTypeDAO.saveEntity(serviceType);
    }

    @Override
    public ServiceType getEntityById(int id) {
        return serviceTypeDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(ServiceType serviceType) {
        serviceTypeDAO.updateEntity(serviceType);
    }

    @Override
    public void removeEntityById(int id) {
        serviceTypeDAO.removeEntityById(id);
    }

    @Override
    public List<ServiceType> getAll() {
        return serviceTypeDAO.getAll();
    }

    @Override
    public ServiceType getServiceTypeByName(String serviceTypeName) {
        return serviceTypeDAO.getServiceTypeByName(serviceTypeName);
    }
}
