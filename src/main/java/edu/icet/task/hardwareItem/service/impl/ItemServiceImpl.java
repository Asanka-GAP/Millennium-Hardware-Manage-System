package edu.icet.task.hardwareItem.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.task.hardwareItem.entity.ItemEntity;
import edu.icet.task.hardwareItem.model.Item;
import edu.icet.task.hardwareItem.repository.ItemRepository;
import edu.icet.task.hardwareItem.service.ItemService;
import edu.icet.task.rental.entity.RentalEntity;
import edu.icet.task.rental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Item persistItem(Item item) {
        ItemEntity itemEntity = repository.save(mapper.convertValue(item, ItemEntity.class));
        return mapper.convertValue(itemEntity, Item.class);
    }

    @Override
    public List<Item> retrieveAll() {
        Iterable<ItemEntity> all = repository.findAll();
        List<Item> itemList =new ArrayList<>();

        all.forEach(itemEntity -> {
            itemList.add(mapper.convertValue(itemEntity, Item.class));
        });
        return itemList;
    }

    @Override
    public Item findById(Long id) {
        ItemEntity itemEntity = repository.findById(id).get();
        return mapper.convertValue(itemEntity, Item.class);
    }

    @Override
    public Item updateItem(Item item) {
        if (repository.existsById(item.getId())){
            ItemEntity itemEntity = repository.save(mapper.convertValue(item, ItemEntity.class));
            return mapper.convertValue(itemEntity, Item.class);
        }
        return null;
    }

    @Override
    public boolean deleteItem(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Item enrollToRental(Long itemId, Long rentalId) {
        ItemEntity itemEntity = null;
        RentalEntity rentalEntity = null;
        if (repository.existsById(itemId)){
            itemEntity = repository.findById(itemId).get();
        }
        if (rentalRepository.existsById(rentalId)){
            rentalEntity = rentalRepository.findById(rentalId).get();
        }

        Set<RentalEntity> rentals= new HashSet<>();
        rentals.add(rentalEntity);
        itemEntity.setBelongRental(rentals);

        ItemEntity saved = repository.save(itemEntity);

        return mapper.convertValue(saved,Item.class);
    }
}
