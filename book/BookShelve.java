package com.yulin.bnta.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookShelve {
     private List<Book> books;
     private int capacity;

    public BookShelve(List<Book> books, int capacity) {
        this.books = books;
        this.capacity = capacity;
    }

    public BookShelve(int capacity) {
        this.capacity = capacity;
        this.books = new ArrayList<Book>(capacity);
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "BookShelve{" +
                "books=" + books +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookShelve that = (BookShelve) o;
        return capacity == that.capacity && Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, capacity);
    }
}
