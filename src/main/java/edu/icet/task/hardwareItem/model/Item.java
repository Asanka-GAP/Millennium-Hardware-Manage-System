package edu.icet.task.hardwareItem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private String availability;
    private Double rentalPerDay;
    private Double finePerDay;
}
