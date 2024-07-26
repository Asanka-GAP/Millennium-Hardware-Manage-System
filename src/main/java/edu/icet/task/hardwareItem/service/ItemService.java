package edu.icet.task.hardwareItem.service;

import edu.icet.task.hardwareItem.model.Item;

import java.util.List;

public interface ItemService {
    Item persistItem(Item item);

    List<Item> retrieveAll();

    Item findById(Long id);

    Item updateItem(Item item);

    boolean deleteItem(Long id);

    Item enrollToRental(Long itemId, Long rentalId);
}
