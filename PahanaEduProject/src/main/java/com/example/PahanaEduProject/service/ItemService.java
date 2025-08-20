package com.example.PahanaEduProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PahanaEduProject.model.Item;
import com.example.PahanaEduProject.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get item by ID
    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    // Save or update an item
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // Delete an item by ID
    public void deleteItemById(String id) {
        itemRepository.deleteById(id);
    }
}
