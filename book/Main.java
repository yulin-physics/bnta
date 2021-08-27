package com.yulin.bnta.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){

        //List.of() is an immutable method
        List<Book> books = new ArrayList<Book>(Arrays.asList(new Book("The Room", Subject.FICTION, Language.ENGLISH),
                new Book("Dictionary", Subject.GENERAL, Language.ENGLISH)));

        BookShelve bookShelve = new BookShelve(books, 10);
        BookShelveService bookShelveService = new BookShelveService();

        List<Book> newBooks = new ArrayList<Book>();
        newBooks.add(new Book("Revision Guide", Subject.AUDIO, Language.GERMAN));
        newBooks.add(new Book("French History", Subject.HISTORICAL, Language.FRENCH));
        bookShelveService.addBooks(newBooks, bookShelve);
        System.out.println(bookShelve.getBooks());


        bookShelveService.removeBooks(newBooks, bookShelve);

        System.out.println(bookShelve.getBooks());


    }
}
