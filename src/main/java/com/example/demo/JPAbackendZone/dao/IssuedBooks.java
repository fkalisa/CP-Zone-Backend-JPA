package com.example.demo.JPAbackendZone.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IssuedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int user_id;

    private int book_id;

    private int status;

    private int counter;

    public IssuedBooks() {
    }

    public IssuedBooks(int user_id, int book_id, int status, int counter) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.status = status;
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
