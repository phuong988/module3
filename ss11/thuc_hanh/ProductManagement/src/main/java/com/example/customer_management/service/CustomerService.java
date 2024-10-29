package com.example.customer_management.service;

import com.example.customer_management.model.Customer;
import com.example.customer_management.repository.CustomerRepository;
import com.example.customer_management.repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return new ArrayList<Customer>(customerRepository.findAll());
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
