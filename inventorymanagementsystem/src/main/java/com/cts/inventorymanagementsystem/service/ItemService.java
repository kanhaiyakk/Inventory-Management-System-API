package com.cts.inventorymanagementsystem.service;

import java.util.List;

import com.cts.inventorymanagementsystem.entity.Item;

public interface ItemService {

    List<Item> getAllItem();
    Item getItemById(Long id);
    Item saveItemDetails(Item item);
    Item updateItem(Long id , Item item);
    void deleteItemById(Long id);
}