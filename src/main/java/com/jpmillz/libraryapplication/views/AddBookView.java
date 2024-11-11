package com.jpmillz.libraryapplication.views;

import com.jpmillz.libraryapplication.domain.Book;
import com.jpmillz.libraryapplication.domain.Genre;
import com.jpmillz.libraryapplication.logic.BookHolder;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class AddBookView {

    private BookHolder books;

    public AddBookView(BookHolder holder){
        this.books = holder;
    }

    public Parent getView() {
        GridPane layout = new GridPane();
        TextField bookName = new TextField();
        TextField authorName = new TextField();
        TextField pageCount = new TextField();
        ComboBox genre = genreComboBox();
        TextField isbn = new TextField();
        Button addBookButton = new Button("Add Book");
        addBookButton.setOnMouseClicked(mouseEvent -> {
            Book book = new Book(bookName.getText(), authorName.getText(), Integer.valueOf(pageCount.getText()), (Genre) genre.getValue(), isbn.getText());
            books.addBook(book);
            System.out.println(bookName + " has been added to the Library");
        });

        Label bookNameLabel = new Label("Book Name:");
        layout.add(bookNameLabel, 0, 0);
        layout.add(bookName, 0, 1);
        bookName.setStyle("-fx-border-radius: 20; -fx-background-radius: 20;");
        layout.add(new Label("Author Name:"), 0, 3);
        layout.add(authorName, 0, 4);
        authorName.setStyle("-fx-border-radius: 20; -fx-background-radius: 20;");
        layout.add(new Label("Page Count:"), 0, 6);
        layout.add(pageCount, 0, 7);
        pageCount.setStyle("-fx-border-radius: 20; -fx-background-radius: 20;");
        layout.add(new Label("ISBN #:"), 0, 9);
        layout.add(isbn, 0, 10);
        isbn.setStyle("-fx-border-radius: 20; -fx-background-radius: 20;");
        layout.add(new Label("Genre:"), 0, 12);
        layout.add(genre, 0, 13);
        genre.setStyle("-fx-border-radius: 20; -fx-background-radius: 20;");
        layout.add(addBookButton, 0, 15);
        addBookButton.setStyle("-fx-border-radius: 20; -fx-background-radius: 20;");



        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setPadding(new Insets(5));
        layout.setVgap(2);

        return layout;
    }

    private ComboBox genreComboBox() {
        ComboBox genres = new ComboBox();
        genres.getItems().addAll(Genre.values());
        return genres;
    }
}
