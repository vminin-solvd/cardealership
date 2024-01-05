package com.solvd.interfaces;

import com.solvd.models.CarSale;

import java.util.List;

public interface iCarSaleDAO extends IBaseDAO<CarSale> {

    List<CarSale> getCarSalesByEmployeeID(int id);
}
