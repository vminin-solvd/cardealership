package com.solvd.factory;

import com.solvd.models.CarType;

public class CarTypeFactory {

    public static CarType createCarType(int id, String carType) {
        return new CarType.Builder()
                .setId(id)
                .setCarType(carType)
                .build();
    }
}

