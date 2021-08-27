package com.yulin.bnta.book;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private Subject subject;
    private LocalDate pubDate;
    private Language lang;

    public Book(String title, String author, Subject subject, LocalDate pubDate, Language lang) {
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.pubDate = pubDate;
        this.lang = lang;
    }

    public Book(String title, Subject subject, Language lang) {
        this.title = title;
        this.subject = subject;
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Subject getSubject() {
        return subject;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public Language getLang() {
        return lang;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", subject=" + subject +
                ", pubDate=" + pubDate +
                ", lang=" + lang +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && subject == book.subject && Objects.equals(pubDate, book.pubDate) && lang == book.lang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, subject, pubDate, lang);
    }
}


