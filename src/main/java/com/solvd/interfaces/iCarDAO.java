package com.solvd.interfaces;

import com.solvd.models.Car;

import java.util.List;

public interface iCarDAO extends IBaseDAO<Car> {
List<Car> getCarsByModel(String model);
}
