package com.example.PahanaEduProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
public class Item {

    @Id
    private String id;

    private String name;
    private String description;
    private double price;
    private int quantity;

    // This will store the uploaded image file name
    private String imageName;

    // Constructors
    public Item() {}

    public Item(String name, String description, double price, int quantity, String imageName) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageName = imageName;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getImageName() { return imageName; }
    public void setImageName(String imageName) { this.imageName = imageName; }
}
