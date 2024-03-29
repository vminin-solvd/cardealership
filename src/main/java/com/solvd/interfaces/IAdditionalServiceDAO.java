package com.solvd.interfaces;

import com.solvd.models.AdditionalService;


public interface IAdditionalServiceDAO extends IBaseDAO<AdditionalService> {
    AdditionalService getAdditionalServiceByServiceName(String serviceName);
}
