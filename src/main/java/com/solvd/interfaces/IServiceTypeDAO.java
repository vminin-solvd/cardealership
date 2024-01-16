package com.solvd.interfaces;

import com.solvd.models.ServiceType;

public interface IServiceTypeDAO extends IBaseDAO<ServiceType> {
    ServiceType getServiceTypeByName(String serviceTypeName);
}
