package edu.icet.task.customer.repository;

import edu.icet.task.customer.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
}
