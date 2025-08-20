package com.example.PahanaEduProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PahanaEduProject.model.Book;
import com.example.PahanaEduProject.repository.BookRepository;

@CrossOrigin(origins = "*")  // Allow frontend JS to fetch
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // ✅ Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // ✅ Get books by category
    @GetMapping("/category/{category}")
    public List<Book> getBooksByCategory(@PathVariable String category) {
        return bookRepository.findByCategory(category);
    }

    // ✅ Add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // ✅ Update a book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow();

        book.setTitle(bookDetails.getTitle());
        book.setCategory(bookDetails.getCategory());
        book.setImage(bookDetails.getImage());

        // Newly added fields
        book.setPrice(bookDetails.getPrice());
        book.setDiscount(bookDetails.getDiscount());

        return bookRepository.save(book);
    }

    // ✅ Delete a book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        bookRepository.deleteById(id);
        return "Book with ID " + id + " deleted successfully!";
    }
}
