package com.jpmillz.libraryapplication.logic;

import com.jpmillz.libraryapplication.domain.Book;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class BookHolder {

    private List<Book> books;

    public BookHolder(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book bookToAdd){
        this.books.add(bookToAdd);
    }

    public List<Book> getBooks(){
        return books;
    }


}
