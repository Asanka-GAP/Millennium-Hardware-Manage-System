package edu.icet.task.rental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.icet.task.customer.entity.CustomerEntity;
import edu.icet.task.hardwareItem.entity.ItemEntity;
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
@Table(name = "rental")
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rentalDate;
    private String returnDate;
    private String dueDate;
    private Long totalCost;
    private Long fine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cus_id",referencedColumnName = "id")
    private CustomerEntity customer;

    @JsonIgnore
    @ManyToMany(mappedBy = "belongRental")
    private Set<ItemEntity> items = new HashSet<>();
}
