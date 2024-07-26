package edu.icet.task.hardwareItem.controller;

import edu.icet.task.customer.model.Customer;
import edu.icet.task.hardwareItem.entity.ItemEntity;
import edu.icet.task.hardwareItem.model.Item;
import edu.icet.task.hardwareItem.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;

    @PostMapping("/item")
    Item persist(@RequestBody Item item){
        return service.persistItem(item);
    }

    @GetMapping("/item/get-all")
    List<Item> retrieveAll(){
        return service.retrieveAll();
    }

    @GetMapping("/item/{id}")
    Item findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/item/update")
    Item updateItem(@RequestBody Item item){
        return service.updateItem(item);
    }

    @DeleteMapping("item/delete/{id}")
    boolean deleteItem(@PathVariable Long id){
        return service.deleteItem(id);
    }

    @PutMapping("/item/{item_id}/{rental_id}")
    Item enrollToRental(@PathVariable Long item_id, @PathVariable Long rental_id){
        return service.enrollToRental(item_id,rental_id);
    }
}
