package com.jpmillz.libraryapplication.views;

import com.jpmillz.libraryapplication.domain.Book;
import com.jpmillz.libraryapplication.domain.Genre;
import com.jpmillz.libraryapplication.logic.BookHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.util.stream.Collectors;

public class BookListView {

    private BookHolder books;

    public BookListView(BookHolder holder){
        this.books = holder;
    }

    public Parent getView(){
        BorderPane layout = new BorderPane();
        TableView booksTable = new TableView<>();
        booksTable.setItems(FXCollections.observableList(books.getBooks()));

        TableColumn<Book, String> nameColumn = new TableColumn<>("Book Name");
        nameColumn.setCellValueFactory(data -> data.getValue().bookNameProperty());
        TableColumn<Book, String> authorColumn = new TableColumn<>("Author Name");
        authorColumn.setCellValueFactory(data -> data.getValue().authorNameProperty());
        TableColumn<Book, Integer> pageCountColumn = new TableColumn<>("Page Count");
        pageCountColumn.setCellValueFactory(data -> data.getValue().pageCountProperty().asObject());
        TableColumn<Book, Genre> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(data -> data.getValue().genreProperty());
        TableColumn<Book, String> isnbColumn = new TableColumn<>("ISBN");
        isnbColumn.setCellValueFactory(data -> data.getValue().isbnProperty());


        booksTable.getColumns().setAll(nameColumn, authorColumn, pageCountColumn, genreColumn, isnbColumn);

        layout.setCenter(booksTable);
        
        return layout;
    }
}
