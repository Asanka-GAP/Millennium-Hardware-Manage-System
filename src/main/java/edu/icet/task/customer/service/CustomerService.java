package edu.icet.task.customer.service;

import edu.icet.task.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer persistCustomer(Customer customer);

    List<Customer> retrieveAll();

    Customer findById(Long id);

    Customer updateCustomer(Customer customer);

    boolean deleteCustomer(Long id);
}
