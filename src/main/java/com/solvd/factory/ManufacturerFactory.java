package com.solvd.factory;

import com.solvd.models.Manufacturer;

public class ManufacturerFactory {

    public static Manufacturer createManufacturer(int id, String manufacturerName) {
        return new Manufacturer.Builder()
                .setId(id)
                .setManufacturerName(manufacturerName)
                .build();
    }
}

