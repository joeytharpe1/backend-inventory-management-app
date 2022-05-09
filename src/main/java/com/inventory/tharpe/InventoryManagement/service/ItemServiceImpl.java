package com.inventory.tharpe.InventoryManagement.service;

import com.inventory.tharpe.InventoryManagement.entity.Item;
import com.inventory.tharpe.InventoryManagement.error.ItemNotFoundException;
import com.inventory.tharpe.InventoryManagement.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) throws ItemNotFoundException {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if(!itemOptional.isPresent())
            throw new ItemNotFoundException("Item with " + id + " not found");
        return itemOptional.get();
    }

    @Override
    public Item updateItem(Long id, Item item) throws ItemNotFoundException {
        Optional<Item> updateItemOptional = itemRepository.findById(id);
        if(!updateItemOptional.isPresent())
            throw new ItemNotFoundException("item with id:" + id + " not found");
        Item itemToUpdate = updateItemOptional.get();
        if(item.getItemName() != null)
            itemToUpdate.setItemName(item.getItemName());
        if(item.getItemPrice() != null)
            itemToUpdate.setItemPrice(item.getItemPrice());
        if(item.getItemQuantity() != null)
            itemToUpdate.setItemQuantity(item.getItemQuantity());
        return itemRepository.save(itemToUpdate);
    }

    @Override
    public Item deleteItem(Long id) throws ItemNotFoundException {
        Optional<Item> itemToDeleteOptional = itemRepository.findById(id);
        if(!itemToDeleteOptional.isPresent())
            throw new ItemNotFoundException("Item with id:" + id + " not found");
        Item deletedItem = itemToDeleteOptional.get();
        itemRepository.delete(deletedItem);
        return deletedItem;
    }
}

