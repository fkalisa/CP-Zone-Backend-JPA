package com.example.demo.JPAbackendZone.repository;

import com.example.demo.JPAbackendZone.DAO.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {

    List<BookCategory> getBookCategoriesByName(String name);
}
