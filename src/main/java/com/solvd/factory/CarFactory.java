package com.solvd.factory;

import com.solvd.models.Car;
import com.solvd.models.CarType;
import com.solvd.models.Manufacturer;

public class CarFactory {

    public static Car createCar(int id, int price, String model, String year, boolean isSold, CarType carType, Manufacturer manufacturer) {
        return new Car.Builder()
                .setId(id)
                .setPrice(price)
                .setModel(model)
                .setYear(year)
                .setIsSold(isSold)
                .setCarType(carType)
                .setManufacturer(manufacturer)
                .build();
    }
}

