package com.inventory.tharpe.InventoryManagement.repository;

import com.inventory.tharpe.InventoryManagement.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
