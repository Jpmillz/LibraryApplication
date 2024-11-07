package com.jpmillz.libraryapplication;

import com.jpmillz.libraryapplication.views.AddBookView;
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

import java.awt.*;

public class LibraryApplication extends Application {

    public static void main(String[] args) {
        launch(LibraryApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainLayout = new BorderPane();
        AddBookView addBookView = new AddBookView();

        HBox topBox = new HBox();
        topBox.setPadding(new Insets(15, 15, 15, 15));
        topBox.setAlignment(Pos.CENTER);
        topBox.setPrefSize(800, 20);
        topBox.setStyle("-fx-border-color: black;");
        Label mainLabel = new Label("Library Management Application");
        mainLabel.setFont(new Font(30));
        mainLabel.setTextAlignment(TextAlignment.CENTER);
        topBox.getChildren().addAll(mainLabel);
        mainLayout.setTop(topBox);



        VBox navMenu = new VBox();
        navMenu.setPadding(new Insets(20, 20, 20, 20));
        Button homeButton = new Button("Home Screen");
        Button booksButton = new Button("View Books");
        navMenu.setAlignment(Pos.CENTER);
        navMenu.setSpacing(10);
        navMenu.setStyle("-fx-border-color: black;");
        navMenu.getChildren().addAll(homeButton, booksButton);

        mainLayout.setLeft(navMenu);
        mainLayout.setCenter(addBookView.getView());

        Scene scene = new Scene(mainLayout, 800, 500);
        stage.setTitle("Library Management Application");
        stage.setScene(scene);
        stage.show();
    }
}
