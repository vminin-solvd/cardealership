package com.solvd;

import com.solvd.models.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.services.OrderService;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        OrderService orderService = new OrderService();

        List<Order> orders = orderService.getAll();

        LOGGER.info(orders);
    }
}