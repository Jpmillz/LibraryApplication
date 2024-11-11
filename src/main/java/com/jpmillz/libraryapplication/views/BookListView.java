package com.jpmillz.libraryapplication.views;

import com.jpmillz.libraryapplication.logic.BookHolder;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class BookListView {

    private BookHolder books;

    public BookListView(BookHolder holder){
        this.books = holder;
    }

    public Parent getView(){
        BorderPane layout = new BorderPane();
        
        return layout;
    }
}
