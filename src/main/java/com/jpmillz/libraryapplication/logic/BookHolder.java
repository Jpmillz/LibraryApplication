package com.jpmillz.libraryapplication.logic;

import com.jpmillz.libraryapplication.domain.Book;
import com.jpmillz.libraryapplication.io.LibraryFileHelper;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookHolder {

    private List<Book> books;
    private LibraryFileHelper fileHelper;

    public BookHolder(LibraryFileHelper fileHelper){
        this.fileHelper = fileHelper;
        this.books = fileHelper.initData();
    }

    public void addBook(Book bookToAdd){
        this.books.add(bookToAdd);
        try{
            fileHelper.saveBooks();
            System.out.println("Saved Books To File");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Book> getBooks(){
        return books;
    }


}
