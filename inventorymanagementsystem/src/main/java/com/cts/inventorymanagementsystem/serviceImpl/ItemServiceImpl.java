package com.cts.inventorymanagementsystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.inventorymanagementsystem.entity.Item;
import com.cts.inventorymanagementsystem.exceptions.ResourceNotFoungException;
import com.cts.inventorymanagementsystem.repository.ItemRepository;
import com.cts.inventorymanagementsystem.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()) {
            return item.get();
        }
        throw new ResourceNotFoungException("Item  not found at id "+id);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item ExistingItem=getItemById(id);
        ExistingItem.setName(item.getName() != null ? item.getName() : ExistingItem.getName());
        ExistingItem.setDescription(item.getDescription() != null ? item.getDescription() : ExistingItem.getDescription());
        ExistingItem.setQuantity(item.getQuantity() != null ? item.getQuantity() : ExistingItem.getQuantity());
        ExistingItem.setPrice(item.getPrice() != null ? item.getPrice() : ExistingItem.getPrice());
        return itemRepository.save(ExistingItem);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item saveItemDetails(Item item) {
        return itemRepository.save(item);
    }

}