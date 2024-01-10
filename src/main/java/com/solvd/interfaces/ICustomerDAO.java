package com.solvd.interfaces;

import com.solvd.models.Customer;

public interface ICustomerDAO extends IBaseDAO<Customer> {
    Customer getCustomerByFirstName(String firstName);
}
