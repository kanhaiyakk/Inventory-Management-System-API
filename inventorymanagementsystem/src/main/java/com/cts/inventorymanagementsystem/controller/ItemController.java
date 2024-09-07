package com.cts.inventorymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.inventorymanagementsystem.entity.Item;
import com.cts.inventorymanagementsystem.service.ItemService;

import jakarta.validation.Valid;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/items")
    public List<Item> getAllItem(){
        return itemService.getAllItem();
    }
    @PostMapping("/items")
    public Item saveItemDetails(@Valid @RequestBody Item item) {
        return itemService.saveItemDetails(item);
    }
    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }
    @DeleteMapping("/items")
    public void deleteItemById(@RequestParam Long id ) {
        itemService.deleteItemById(id);
    }
    @PutMapping("/items/{id}")
    public Item updateItem(@RequestBody Item item , @PathVariable Long id) {
        return itemService.updateItem(id, item);
    }

}