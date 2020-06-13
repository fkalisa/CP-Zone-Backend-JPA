package com.example.demo.JPAbackendZone.repository;

import com.example.demo.JPAbackendZone.dao.IssuedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooks, Integer> {
}
