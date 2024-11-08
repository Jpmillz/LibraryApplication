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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
