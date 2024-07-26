package edu.icet.task.rental.model;

import edu.icet.task.customer.entity.CustomerEntity;
import edu.icet.task.customer.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    private Long id;
    private String rentalDate;
    private String returnDate;
    private String dueDate;
    private Long totalCost;
    private Long fine;
    private Customer customer;
}
