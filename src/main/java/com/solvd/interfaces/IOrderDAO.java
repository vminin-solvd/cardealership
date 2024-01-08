package com.solvd.interfaces;

import com.solvd.models.Order;

import java.util.List;

public interface IOrderDAO extends IBaseDAO<Order> {
List<Order> getOrdersByEmployeeID(int id);
}
