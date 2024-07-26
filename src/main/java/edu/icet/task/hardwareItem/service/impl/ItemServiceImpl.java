package edu.icet.task.hardwareItem.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.task.hardwareItem.entity.ItemEntity;
import edu.icet.task.hardwareItem.model.Item;
import edu.icet.task.hardwareItem.repository.ItemRepository;
import edu.icet.task.hardwareItem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

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
}
