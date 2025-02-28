package com.example.lab56Demo.service;
import com.example.lab56Demo.entity.Item;
import java.util.List;
import java.util.Optional;
public interface ItemService {
List<Item> getAllItems();
Optional<Item> getItemById(Long id);
Item createItem(Item item);
Item updateItem(Long id, Item itemDetails);
void deleteItem(Long id);
}