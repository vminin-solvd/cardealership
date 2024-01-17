package com.solvd.interfaces;

import com.solvd.models.CarType;

public interface ICarTypeDAO extends IBaseDAO<CarType> {
        CarType getCarTypeByName(String carType);
}
