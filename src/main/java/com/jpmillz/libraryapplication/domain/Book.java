package com.jpmillz.libraryapplication.domain;

public class Book {

    private String bookName;
    private String authorName;
    private int pageCount;
    private Genre genre;
    private String isbn;

    public Book(String name, String author, int pageCount, Genre genre, String isbn){
        this.bookName = name;
        this.authorName = author;
        this.pageCount = pageCount;
        this.genre = genre;
        this.isbn = isbn;
    }
}
