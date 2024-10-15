package com.cts.inventorymanagementsystem.itemServiceTest;

import com.cts.inventorymanagementsystem.entity.Item;
import com.cts.inventorymanagementsystem.repository.ItemRepository;
import com.cts.inventorymanagementsystem.serviceImpl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    private Item item;


//    private Integer quantity;
//    private BigDecimal price;
//    private String description;
//    private String name;
//    private Long id;
//
//    @BeforeEach
//    public void setup(){
//        // Initialize the Item object
//        item = new Item();              // Assuming Item has a default constructor
//
//        // Initialize ID, name, description, quantity, and price
//        id = 1L;                       // Example ID
//        name = "Dove";          // Example name
//        description = "A sample item for testing purposes."; // Example description
//        quantity = 5;                  // Example quantity
//        price = BigDecimal.valueOf(10.00); // Example price
//
//        item.setId(id);
//        item.setName(name);
//        item.setQuantity(quantity);
//        item.setPrice(price);
//        item.setDescription(description);
//   }
@BeforeEach
public void setup() {
    item = Item.builder()
            .id(1L)
            .name("Dove")
            .description("A sample item for testing purposes.")
            .quantity(5)
            .price(BigDecimal.valueOf(10.00))
            .build();
}


    @Test
    public void testCreateUser(){
        Mockito.when(itemRepository.save(Mockito.any(Item.class))).thenReturn(item);
        Item createdItem = itemService.saveItemDetails(item);
        assertNotNull(createdItem);
        assertEquals("Dove",createdItem.getName());
        assertEquals(5,createdItem.getQuantity());
       // assertEquals(10.00,createdItem.getPrice());
        assertEquals(BigDecimal.valueOf(10.0), createdItem.getPrice());

    }

    @Test
    public void testGetItemById(){
        Mockito.when(itemRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(item));
        Item foundItem  = itemService.getItemById(1L);
        assertNotNull(foundItem);
        assertEquals("Dove",foundItem.getName());
        assertEquals(5,foundItem.getQuantity());
        assertEquals(BigDecimal.valueOf(10.0), foundItem.getPrice());

    }

    @Test
    public void testUpdateItem(){
        // Mocking the repository methods to return the existing item and then save the updated item
        Mockito.when(itemRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(item));
        Mockito.when(itemRepository.save(Mockito.any(Item.class))).thenReturn(item);

        // Modifying the item's details
        item.setName("Lux");
        item.setQuantity(10);
        item.setPrice(BigDecimal.valueOf(15.0));

        // Calling the service method to update the item
        Item updatedItem = itemService.updateItem(1L,item);

        // Verifying that the updated item has the new values
        assertNotNull(updatedItem);
        assertEquals("Lux", updatedItem.getName());
        assertEquals(10, updatedItem.getQuantity());
        assertEquals(BigDecimal.valueOf(15.0), updatedItem.getPrice());

        // Verifying that the repository's findById and save methods were called once
        Mockito.verify(itemRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(itemRepository, Mockito.times(1)).save(item);

    }
    @Test
    public void testDeleteItem() {
        // Mocking the repository's findById method to return the item
        Mockito.when(itemRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(item));

        // Mocking the repository's deleteById method to do nothing
        Mockito.doNothing().when(itemRepository).deleteById(Mockito.anyLong());

        // Calling the service method to delete the item
        itemService.deleteItemById(1L);

        // Verifying that the repository's deleteById method was called once
        Mockito.verify(itemRepository, Mockito.times(1)).deleteById(1L);
    }
}
