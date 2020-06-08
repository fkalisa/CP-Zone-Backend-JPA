package com.example.demo.JPAbackendZone.request;

public class BookRequest {

    private String name;
    private String authorName;
    private int cost;
    private int BookCategoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getBookCategoryId() {
        return BookCategoryId;
    }

    public void setBookCategoryId(int bookCategoryId) {
        BookCategoryId = bookCategoryId;
    }
}
