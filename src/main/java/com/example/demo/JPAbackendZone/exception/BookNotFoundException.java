package com.example.demo.JPAbackendZone.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(int id) {
        super("Book not found " + id);
    }
}
