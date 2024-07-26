package edu.icet.task.rental.service;

import edu.icet.task.rental.model.Rental;

import java.util.List;

public interface RentalService {
    Rental persistRental(Rental rental);

    List<Rental> retrieveAll();

    Rental findById(Long id);

    Rental updateRental(Rental rental);

    boolean deleteRental(Long id);
}
