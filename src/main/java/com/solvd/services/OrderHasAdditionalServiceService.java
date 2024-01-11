package com.solvd.services;

import com.solvd.interfaces.IOrderHasAdditionalServicesDAO;
import com.solvd.models.OrderHasAdditionalService;
import com.solvd.mybatis.dao.OrderHasAdditionalServiceDAO;
import com.solvd.models.AdditionalService;

import java.util.List;

public class OrderHasAdditionalServiceService implements IOrderHasAdditionalServicesDAO<OrderHasAdditionalService, AdditionalService>  {

    private OrderHasAdditionalServiceDAO orderHasAdditionalServiceDAO = new OrderHasAdditionalServiceDAO();

    @Override
    public void saveEntity(OrderHasAdditionalService orderHasAdditionalService) {
        orderHasAdditionalServiceDAO.saveEntity(orderHasAdditionalService);
    }

    @Override
    public OrderHasAdditionalService getEntityById(int id) {
        return orderHasAdditionalServiceDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(OrderHasAdditionalService orderHasAdditionalService) {
        orderHasAdditionalServiceDAO.updateEntity(orderHasAdditionalService);
    }

    @Override
    public void removeEntityById(int id) {
        orderHasAdditionalServiceDAO.removeEntityById(id);
    }

    @Override
    public List<OrderHasAdditionalService> getAll() {
        return orderHasAdditionalServiceDAO.getAll();
    }

    @Override
    public List<AdditionalService> getAllServicesById(int id) {
        return orderHasAdditionalServiceDAO.getAllServicesById(id);
    }
}
