package com.solvd.services;

import com.solvd.interfaces.iOrderDAO;
import com.solvd.jbdc.dao.OrderDAO;
import com.solvd.models.Order;

import java.util.List;

public class OrderService implements iOrderDAO {

    OrderDAO orderDAO = new OrderDAO();

    @Override
    public void saveEntity(Order order) {
        orderDAO.saveEntity(order);
    }

    @Override
    public Order getEntityById(int id) {
        return orderDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(Order order) {
        orderDAO.updateEntity(order);
    }

    @Override
    public void removeEntityById(int id) {
        orderDAO.removeEntityById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public List<Order> getOrdersByEmployeeID(int id) {
        return orderDAO.getOrdersByEmployeeID(id);
    }
}
