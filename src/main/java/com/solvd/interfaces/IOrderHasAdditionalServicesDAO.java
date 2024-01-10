package com.solvd.interfaces;

import com.solvd.models.AdditionalService;
import com.solvd.models.OrderHasAdditionalService;

import java.util.List;

public interface IOrderHasAdditionalServicesDAO<OrderHasAdditionalServices, AdditionalServices> extends IBaseDAO<OrderHasAdditionalService> {
    List<AdditionalService> getAllServicesById(int id);

}
