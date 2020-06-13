package com.example.demo.JPAbackendZone.repository;

import com.example.demo.JPAbackendZone.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> getBooksByAuthorName(String authorName);

    List<Book> getBooksByName(String name);
}
