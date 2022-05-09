package com.inventory.tharpe.InventoryManagement.service;

import com.inventory.tharpe.InventoryManagement.entity.Item;
import com.inventory.tharpe.InventoryManagement.error.ItemNotFoundException;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);

    List<Item> getAllItems();

    Item getItemById(Long id) throws ItemNotFoundException;

    Item updateItem(Long id, Item item) throws ItemNotFoundException;

    Item deleteItem(Long id) throws ItemNotFoundException;
}
