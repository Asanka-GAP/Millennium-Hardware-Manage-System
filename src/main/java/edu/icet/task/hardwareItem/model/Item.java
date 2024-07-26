package edu.icet.task.hardwareItem.model;

import edu.icet.task.rental.entity.RentalEntity;
import edu.icet.task.rental.model.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private String availability;
    private Double rentalPerDay;
    private Double finePerDay;
    private Set<Rental> belongRental = new HashSet<>();
}
