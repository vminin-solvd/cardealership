package com.solvd.factory;

import com.solvd.interfaces.IBaseDAO;
import com.solvd.mybatis.dao.*;

public class MyBatisDAOFactory {

    public IBaseDAO getDAO(String name) {
        return switch (name) {
            case "AdditionalService"         -> new AdditionalServiceDAO();
            case "Car"                       -> new CarDAO();
            case "CarSale"                   -> new CarSaleDAO();
            case "CarType"                   -> new CarTypeDAO();
            case "Customer"                  -> new CustomerDAO();
            case "Employee"                  -> new EmployeeDAO();
            case "Manufacturer"              -> new ManufacturerDAO();
            case "Order"                     -> new OrderDAO();
            case "OrderHasAdditionalService" -> new OrderHasAdditionalServiceDAO();
            case "Position"                  -> new PositionDAO();
            case "ServiceType"               -> new ServiceTypeDAO();
            case "TestDrive"                 -> new TestDriveDAO();
            default -> throw new IllegalStateException("Unexpected value: " + name);
        };
    }
}
