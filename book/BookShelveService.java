package com.yulin.bnta.book;

import java.util.Arrays;
import java.util.List;

public class BookShelveService {

    private boolean isAddable(List<Book> books, BookShelve bookShelve){
        int addSize = books.size();
        int availableSize = bookShelve.getCapacity() - bookShelve.getBooks().size();
        if (availableSize >= addSize && !bookShelve.getBooks().containsAll(books)){
            return true;
        }else{
            return false;
        }
    }

    public void addBooks(List<Book> books, BookShelve bookShelve){
        if (isAddable(books, bookShelve)){
            bookShelve.getBooks().addAll(books);

        } else {
            throw new IllegalArgumentException("Exceeding bookShelve set capacity: "+ bookShelve.getCapacity()
                     +"\n or books already exist on bookShelve: "+bookShelve.getBooks()
            );
        }
    }

    public void removeBooks(List<Book> books, BookShelve bookShelve){

        if (bookShelve.getBooks().containsAll(books)){
//            int indexOfBook = bookShelve.getBooks().indexOf(books.get(books.size() - 1));
//
//            List<Book> temp = bookShelve.getBooks().subList(0, indexOfBook+1);
//
//            temp.removeAll(books);

            bookShelve.getBooks().removeAll(books);

        } else {
            throw new IllegalArgumentException("Book(s) do not exist in bookShelve: "+ bookShelve.getBooks());
        }
    }

    public void removeAll(BookShelve bookShelve){
        bookShelve.getBooks().clear();
    }




}
