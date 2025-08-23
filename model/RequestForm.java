package com.example.PahanaEduProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book_requests")
public class RequestForm {

    @Id
    private String id;
    private String name;
    private String email;
    private String bookTitle;
    private String details;

    public RequestForm() {}

    public RequestForm(String name, String email, String bookTitle, String details) {
        this.name = name;
        this.email = email;
        this.bookTitle = bookTitle;
        this.details = details;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
