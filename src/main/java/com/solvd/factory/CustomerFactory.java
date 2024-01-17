package com.solvd.factory;

import com.solvd.models.Customer;

public class CustomerFactory {

    public static Customer createCustomer(int id, String firstName, String lastName) {
        return new Customer.Builder()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}
