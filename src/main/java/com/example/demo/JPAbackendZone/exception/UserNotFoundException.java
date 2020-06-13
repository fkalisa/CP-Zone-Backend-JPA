package com.example.demo.JPAbackendZone.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("User not found " + id);
    }
}
