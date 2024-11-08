package com.jpmillz.libraryapplication.views;

import com.jpmillz.libraryapplication.domain.Book;
import com.jpmillz.libraryapplication.domain.Genre;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AddBookView {

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
        });

        layout.add(new Label("Book Name:"), 0, 0);
        layout.add(bookName, 0, 1);
        layout.add(new Label("Author Name:"), 0, 3);
        layout.add(authorName, 0, 4);
        layout.add(new Label("Page Count:"), 0, 6);
        layout.add(pageCount, 0, 7);
        layout.add(new Label("ISBN #:"), 0, 9);
        layout.add(isbn, 0, 10);
        layout.add(new Label("Genre:"), 0, 12);
        layout.add(genre, 0, 13);
        layout.add(addBookButton, 0, 15);
        addBookButton.setStyle("-fx-border-radius: 20; -fx-background-radius: 20;");
        bookName.setStyle("-fx-border-radius: 20; -fx-background-radius: 20;");


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
