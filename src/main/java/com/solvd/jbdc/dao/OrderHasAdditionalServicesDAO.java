package com.solvd.jbdc.dao;

import com.solvd.interfaces.IOrderHasAdditionalServices;
import com.solvd.models.AdditionalService;
import com.solvd.models.OrderHasAdditionalService;
import com.solvd.models.AdditionalService;
import com.solvd.models.Order;
import com.solvd.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderHasAdditionalServicesDAO implements IOrderHasAdditionalServices<OrderHasAdditionalService, AdditionalService> {
    private static final Logger LOGGER = LogManager.getLogger(OrderHasAdditionalServicesDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
// FIXME I will implement this in the morning
}
