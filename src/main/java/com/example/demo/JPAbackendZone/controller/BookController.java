package com.example.demo.JPAbackendZone.controller;

import com.example.demo.JPAbackendZone.DAO.Book;
import com.example.demo.JPAbackendZone.DAO.BookCategory;
import com.example.demo.JPAbackendZone.repository.BookCategoryRepository;
import com.example.demo.JPAbackendZone.repository.BookRepository;
import com.example.demo.JPAbackendZone.request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public void insertBook(@RequestBody BookRequest bookRequest) {
        Optional<BookCategory> bookCategoryIdOptional = bookCategoryRepository.findById(bookRequest.getBookCategoryId());
        Book book = null;
        if (bookCategoryIdOptional.isPresent()) {
            book = new Book(bookRequest.getName(), bookRequest.getAuthorName(), bookRequest.getCost(), bookCategoryIdOptional.get());
        } else {
            book = new Book(bookRequest.getName(), bookRequest.getAuthorName(), bookRequest.getCost(), bookRequest.getBookCategoryId());
        }

        bookRepository.save(book);
    }

    @GetMapping("/booksByAuthorName/{authorName}")
    public List<Book> getBooksByAuthorName(@PathVariable String authorName) {
        return bookRepository.getBooksByAuthorName(authorName);
    }

    @GetMapping("/booksByName/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookRepository.getBooksByName(name);
    }

    @DeleteMapping("/books/{id}")
    public void deleteById(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }

    @PutMapping("/books/{id}")
    public void updateById(@PathVariable Integer id, @RequestBody BookRequest bookRequest) {

        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setName(bookRequest.getName());
            book.setAuthorName(bookRequest.getAuthorName());
            book.setCost(bookRequest.getCost());
            bookRepository.save(book);

        }

    }


}
