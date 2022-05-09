package com.inventory.tharpe.InventoryManagement.controller;

import com.inventory.tharpe.InventoryManagement.entity.Item;
import com.inventory.tharpe.InventoryManagement.error.ItemNotFoundException;
import com.inventory.tharpe.InventoryManagement.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RequestMapping("/item")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
    private final ItemService itemService;
    public final Logger LOGGER = Logger.getLogger(String.valueOf(ItemController.class));

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        LOGGER.info("inside addItem of ItemController");
        Item newItem = itemService.addItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems(){
        LOGGER.info("inside getAllItems of ItemController");
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") Long id) throws ItemNotFoundException {
        LOGGER.info("inside getItemById of ItemController");
        Item item = itemService.getItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") Long id, @RequestBody Item item) throws ItemNotFoundException {
        LOGGER.info("inside updateItem of ItemController");
        Item updatedItem = itemService.updateItem(id, item);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable("id") Long id) throws ItemNotFoundException {
        LOGGER.info("inside deleteItem of ItemController");
        Item deletedItem = itemService.deleteItem(id);
        return new ResponseEntity<>(deletedItem, HttpStatus.OK);
    }
}
