package com.example.PahanaEduProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.PahanaEduProject.model.Item;
import com.example.PahanaEduProject.service.ItemService;

@Controller
@RequestMapping("/admin/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Display all items
    @GetMapping
    public String manageItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        model.addAttribute("pageTitle", "Manage Items - Admin Dashboard");
        return "manage_items";  // Thymeleaf template
    }

    // Show Add Item page
    @GetMapping("/add")
    public String showAddItemForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("pageTitle", "Add New Item");
        return "add_item";  // Thymeleaf template
    }

    // Handle Add Item form submission
    @PostMapping("/add")
    public String addItem(Item item) {
        itemService.saveItem(item);
        return "redirect:/admin/items";
    }

    // Show Edit Item page
    @GetMapping("/edit/{id}")
    public String showEditItemForm(@PathVariable String id, Model model) {
        Optional<Item> itemOpt = itemService.getItemById(id);
        if (itemOpt.isPresent()) {
            model.addAttribute("item", itemOpt.get());
            model.addAttribute("pageTitle", "Edit Item");
            return "edit_item";  // Thymeleaf template
        } else {
            return "redirect:/admin/items";
        }
    }

    // Handle Edit Item form submission
    @PostMapping("/edit/{id}")
    public String editItem(Item item) {
        itemService.saveItem(item);
        return "redirect:/admin/items";
    }

    // Delete Item
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable String id) {
        itemService.deleteItemById(id);
        return "redirect:/admin/items";
    }
}
