package com.solvd.interfaces;

import com.solvd.models.Customer;

public interface iCustomerDAO extends IBaseDAO<Customer> {
    Customer getCustomerByFirstName(String firstName);
}
