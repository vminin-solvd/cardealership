package com.solvd.interfaces;

import com.solvd.models.CarType;

public interface iCarTypeDAO extends IBaseDAO<CarType> {
CarType getCarTypeByName(String carType);
        }
