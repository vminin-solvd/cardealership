package com.solvd.interfaces;

import com.solvd.models.ServiceType;

public interface iServiceTypeDAO extends IBaseDAO<ServiceType> {
ServiceType getServiceTypeByName(String serviceTypeName);
}
