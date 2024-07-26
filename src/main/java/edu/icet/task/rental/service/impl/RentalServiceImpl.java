package edu.icet.task.rental.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.task.customer.entity.CustomerEntity;
import edu.icet.task.customer.repository.CustomerRepository;
import edu.icet.task.rental.entity.RentalEntity;
import edu.icet.task.rental.model.Rental;
import edu.icet.task.rental.repository.RentalRepository;
import edu.icet.task.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Rental persistRental(Rental rental) {
        RentalEntity rentalEntity = repository.save(mapper.convertValue(rental, RentalEntity.class));
        return mapper.convertValue(rentalEntity, Rental.class);
    }

    @Override
    public List<Rental> retrieveAll() {
        Iterable<RentalEntity> all = repository.findAll();
        List<Rental> rentalList = new ArrayList<>();

        all.forEach(rentalEntity -> {
            rentalList.add(mapper.convertValue(rentalEntity, Rental.class));
        });
        return rentalList;
    }

    @Override
    public Rental findById(Long id) {
        RentalEntity rentalEntity = repository.findById(id).get();
        return mapper.convertValue(rentalEntity, Rental.class);
    }

    @Override
    public Rental updateRental(Rental rental) {
        if (repository.existsById(rental.getId())){
            RentalEntity rentalEntity = repository.save(mapper.convertValue(rental, RentalEntity.class));
            return mapper.convertValue(rentalEntity, Rental.class);
        }
        return null;
    }

    @Override
    public boolean deleteRental(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Rental assignCustomer(Long rentalId, Long customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).get();
        RentalEntity rentalEntity = repository.findById(rentalId).get();

        rentalEntity.setCustomer(customerEntity);

        RentalEntity saved = repository.save(rentalEntity);
        return mapper.convertValue(saved, Rental.class);

    }
}
