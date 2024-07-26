package edu.icet.task.hardwareItem.repository;

import edu.icet.task.hardwareItem.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemEntity,Long> {
}
