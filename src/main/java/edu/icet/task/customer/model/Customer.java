package edu.icet.task.customer.model;

import edu.icet.task.rental.entity.RentalEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String city;
    private String contact;

    private Set<RentalEntity> rentals = new HashSet<>();
}
