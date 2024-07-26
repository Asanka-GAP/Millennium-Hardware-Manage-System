package edu.icet.task.rental.repository;

import edu.icet.task.rental.entity.RentalEntity;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<RentalEntity,Long> {
}
