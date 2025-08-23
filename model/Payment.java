package com.example.PahanaEduProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class Payment {

    @Id
    private String id;
    private String bookTitle;
    private double price;
    private String paymentMethod;

    public Payment() {}

    public Payment(String bookTitle, double price, String paymentMethod) {
        this.bookTitle = bookTitle;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
