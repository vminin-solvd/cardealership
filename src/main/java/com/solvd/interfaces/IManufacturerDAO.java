package com.solvd.interfaces;

import com.solvd.models.Manufacturer;

public interface IManufacturerDAO extends IBaseDAO<Manufacturer> {
Manufacturer getManufacturerByName(String manufacturerName);
}
