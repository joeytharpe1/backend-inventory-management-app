package com.inventory.tharpe.InventoryManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Products")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "item_name" , nullable = false )
//    @NotBlank(message = "Name may not be blank")
    private String itemName;

    @Column(name = "item_price" , nullable = false)
//    @NotBlank(message = "Price may not be blank")
    private Double itemPrice;

    @Column(name = "item_quantity" , nullable = false)
//    @NotBlank(message = "Quantity may not be blank")
    private Integer itemQuantity;
}
