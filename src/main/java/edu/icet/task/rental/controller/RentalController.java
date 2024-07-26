package edu.icet.task.rental.controller;

import edu.icet.task.rental.model.Rental;
import edu.icet.task.rental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class RentalController {
    private final RentalService service;

    @PostMapping("/rental")
    Rental persist(@RequestBody Rental rental){
        return service.persistRental(rental);
    }

    @GetMapping("/rental/get-all")
    List<Rental> retrieveAll(){
        return service.retrieveAll();
    }

    @GetMapping("/rental/{id}")
    Rental findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/rental/update")
    Rental updateRental(@RequestBody Rental rental){
        return service.updateRental(rental);
    }

    @DeleteMapping("rental/delete/{id}")
    boolean deleteRental(@PathVariable Long id){
        return service.deleteRental(id);
    }

    @GetMapping("/rental/{rental_id}/{customer_id}")
    Rental assignCustomer(@PathVariable Long rental_id,@PathVariable Long customer_id){
        return service.assignCustomer(rental_id,customer_id);
    }
}
