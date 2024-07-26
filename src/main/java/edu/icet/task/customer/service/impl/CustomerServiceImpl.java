package edu.icet.task.customer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.task.customer.entity.CustomerEntity;
import edu.icet.task.customer.model.Customer;
import edu.icet.task.customer.repository.CustomerRepository;
import edu.icet.task.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Customer persistCustomer(Customer customer) {
        CustomerEntity customerEntity = repository.save(mapper.convertValue(customer, CustomerEntity.class));
        return mapper.convertValue(customerEntity, Customer.class);
    }

    @Override
    public List<Customer> retrieveAll() {
        Iterable<CustomerEntity> all = repository.findAll();
        List<Customer> customerList = new ArrayList<>();

        all.forEach(customerEntity -> {
            customerList.add(mapper.convertValue(customerEntity, Customer.class));
        });

        return customerList;
    }

    @Override
    public Customer findById(Long id) {
        CustomerEntity customerEntity = repository.findById(id).get();

        return mapper.convertValue(customerEntity, Customer.class);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (repository.existsById(customer.getId())){
            CustomerEntity customerEntity = repository.save(mapper.convertValue(customer, CustomerEntity.class));
return mapper.convertValue(customerEntity, Customer.class);
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
