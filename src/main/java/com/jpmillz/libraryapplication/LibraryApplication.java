package com.jpmillz.libraryapplication;

import com.jpmillz.libraryapplication.io.LibraryFileHelper;
import com.jpmillz.libraryapplication.logic.BookHolder;
import com.jpmillz.libraryapplication.views.AddBookView;
import com.jpmillz.libraryapplication.views.BookListView;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LibraryApplication extends Application {

    private BookHolder books;
    private LibraryFileHelper fileHelper;

    public static void main(String[] args) {
        launch(LibraryApplication.class);
    }

    @Override
    public void init() throws Exception {
        fileHelper = new LibraryFileHelper();
        books = new BookHolder(fileHelper);
        fileHelper.setHolder(books);

    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainLayout = new BorderPane();
        AddBookView addBookView = new AddBookView(books);
        BookListView bookListView = new BookListView(books);

        mainLayout.setStyle("-fx-background-color: gray");

        HBox topBox = new HBox();
        topBox.setPadding(new Insets(15, 15, 15, 15));
        topBox.setAlignment(Pos.CENTER);
        topBox.setPrefSize(800, 20);
        topBox.setStyle("-fx-border-radius: 20; -fx-border-color: black; -fx-padding: 20, 20, 20, 20;");
        Label mainLabel = new Label("Library Management Application");
        mainLabel.setFont(new Font(30));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        topBox.getChildren().addAll(mainLabel);
        mainLayout.setTop(topBox);



        VBox navMenu = new VBox();
        navMenu.setPadding(new Insets(20, 20, 20, 20));
        Button homeButton = new Button("Dashboard");
        homeButton.setStyle("-fx-pref-height: 80px; -fx-pref-width: 80px;");
        Button booksButton = new Button("Browse \n Books");
        booksButton.setStyle("-fx-pref-height: 80px; -fx-pref-width: 80px;");
        booksButton.setOnAction(actionEvent -> mainLayout.setCenter(bookListView.getView()));
        Button addBooksButton = new Button("Add Books");
        addBooksButton.setOnAction(event -> mainLayout.setCenter(addBookView.getView()));
        addBooksButton.setStyle("-fx-pref-height: 80px; -fx-pref-width: 80px;");

        navMenu.setAlignment(Pos.CENTER);
        navMenu.setSpacing(10);
        navMenu.setStyle("-fx-border-radius: 20; -fx-border-color: black;");
        navMenu.getChildren().addAll(homeButton, booksButton, addBooksButton);

        mainLayout.setLeft(navMenu);
        mainLayout.setCenter(addBookView.getView());
        mainLayout.setPadding(new Insets(10));
        BorderPane.setMargin(topBox, new Insets(10));
        BorderPane.setMargin(navMenu, new Insets(10));

        Scene scene = new Scene(mainLayout, 800, 500);
        stage.setTitle("Library Management Application");
        stage.setScene(scene);
        stage.show();
    }
}
