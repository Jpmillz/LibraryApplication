package com.jpmillz.libraryapplication.domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {

    private SimpleStringProperty bookName;
    private SimpleStringProperty authorName;
    private IntegerProperty pageCount;
    private SimpleObjectProperty<Genre> genre;
    private SimpleStringProperty isbn;

    public Book(String bookName, String authorName, int pageCount, Genre genre, String isbn){
        this.bookName = new SimpleStringProperty(bookName);
        this.authorName = new SimpleStringProperty(authorName);
        this.pageCount = new SimpleIntegerProperty(pageCount);
        this.genre = new SimpleObjectProperty<>(genre);
        this.isbn = new SimpleStringProperty(isbn);
    }

    public String getBookName() {
        return bookName.get();
    }

    public SimpleStringProperty bookNameProperty() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }

    public String getAuthorName() {
        return authorName.get();
    }

    public SimpleStringProperty authorNameProperty() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName.set(authorName);
    }

    public int getPageCount() {
        return pageCount.get();
    }

    public IntegerProperty pageCountProperty() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount.set(pageCount);
    }

    public Genre getGenre() {
        return genre.get();
    }

    public SimpleObjectProperty<Genre> genreProperty() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre.set(genre);
    }

    public String getIsbn() {
        return isbn.get();
    }

    public SimpleStringProperty isbnProperty() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }
}
