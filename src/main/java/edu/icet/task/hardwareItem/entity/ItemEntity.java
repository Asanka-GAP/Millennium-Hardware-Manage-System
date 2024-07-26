package edu.icet.task.hardwareItem.entity;

import edu.icet.task.rental.entity.RentalEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String availability;
    private Double rentalPerDay;
    private Double finePerDay;

    @ManyToMany
    @JoinTable(
            name = "rental_details",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "rental_id")
    )
    private Set<RentalEntity> belongRental = new HashSet<>();
}
