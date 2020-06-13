package com.example.demo.JPAbackendZone.resource;

import com.example.demo.JPAbackendZone.dao.BookCategory;
import com.example.demo.JPAbackendZone.repository.BookCategoryRepository;
import com.example.demo.JPAbackendZone.request.BookCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookCategoryController {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @GetMapping("/bookCategories")
    public List<BookCategory> getBookCategories() {
        return bookCategoryRepository.findAll();
    }

    @PostMapping("/bookCategory")
    public void insertBookCategory(@RequestBody BookCategoryRequest bookCategoryRequest) {
        BookCategory bookCategory = new BookCategory(bookCategoryRequest.getName());
        bookCategoryRepository.save(bookCategory);
    }

    @GetMapping("/bookCategories/{name}")
    public List<BookCategory> getBookCategoryByName(@PathVariable String name) {
        return bookCategoryRepository.getBookCategoriesByName(name);
    }
}
