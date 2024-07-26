package edu.icet.task.customer.controller;


import edu.icet.task.customer.model.Customer;
import edu.icet.task.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping("/customer")
    Customer persist(@RequestBody Customer customer){
        return service.persistCustomer(customer);
    }

    @GetMapping("/customer/get-all")
    List<Customer> retrieveAll(){
        return service.retrieveAll();
    }

    @GetMapping("/customer/{id}")
    Customer findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/customer/update")
    Customer updateCustomer(@RequestBody Customer customer){
        return service.updateCustomer(customer);
    }

    @DeleteMapping("customer/delete/{id}")
    boolean deleteCustomer(@PathVariable Long id){
       return service.deleteCustomer(id);
    }
}
