package com.solvd.interfaces;

import com.solvd.models.AdditionalService;


public interface iAdditionalServiceDAO extends IBaseDAO<AdditionalService> {
AdditionalService getAdditionalServiceByServiceName(String serviceName);
}
