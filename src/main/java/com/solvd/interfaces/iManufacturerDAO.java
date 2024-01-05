package com.solvd.interfaces;

import com.solvd.models.Manufacturer;

public interface iManufacturerDAO extends IBaseDAO<Manufacturer> {
Manufacturer getManufacturerByName(String manufacturerName);
}
