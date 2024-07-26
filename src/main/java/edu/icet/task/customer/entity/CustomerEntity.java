package edu.icet.task.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String contact;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<RentalEntity> rentals = new HashSet<>();
}
