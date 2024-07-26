package edu.icet.task.rental.model;

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
    private Integer dueDate;
    private Long totalCost;
    private Long fine;
}
