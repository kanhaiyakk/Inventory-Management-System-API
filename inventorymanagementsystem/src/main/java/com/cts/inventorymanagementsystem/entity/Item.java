package com.cts.inventorymanagementsystem.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="inventory_tbl")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="Item_Name")
    @NotBlank(message= "Item name must not be null")
    @Size(min =3, message="Item name must be more than three characters")
    public String name;
    @Column(name="Item_Description")
    public String description;
    @NotNull(message = "Quantity must not be null")
    @Column(name="Item_Quantity")
    public Integer quantity;
    @NotNull(message = "Amount must not be null")
    @Column(name="Item_Price")
    public BigDecimal price;

}