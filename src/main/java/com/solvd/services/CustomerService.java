package com.solvd.services;

import com.solvd.interfaces.ICustomerDAO;
import com.solvd.mybatis.dao.CustomerDAO;
import com.solvd.models.Customer;

import java.util.List;

public class CustomerService implements ICustomerDAO {

    private CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public void saveEntity(Customer customer) {
        customerDAO.saveEntity(customer);
    }

    @Override
    public Customer getEntityById(int id) {
        return customerDAO.getEntityById(id);
    }

    @Override
    public void updateEntity(Customer customer) {
        customerDAO.updateEntity(customer);
    }

    @Override
    public void removeEntityById(int id) {
        customerDAO.removeEntityById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    public Customer getCustomerByFirstName(String firstName) {
        return customerDAO.getCustomerByFirstName(firstName);
    }
}
