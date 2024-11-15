package com.jpmillz.libraryapplication.io;

import com.jpmillz.libraryapplication.domain.Book;
import com.jpmillz.libraryapplication.domain.Genre;
import com.jpmillz.libraryapplication.logic.BookHolder;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LibraryFileHelper {

    private BookHolder holder;
    private File file;

    public LibraryFileHelper() throws Exception{
        file = new File("books.csv");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("Created new Book data file");
        }else {
            System.out.println("Book data file already exists");
        }
    }

    public void setHolder(BookHolder holder){
        this.holder = holder;
    }

    public List<Book> initData(){
        List<Book> books = new ArrayList<>();
        try{
            Files.lines(Paths.get(file.getPath())).forEach(line -> {
                String[] booksParts = line.split(",");
                if (booksParts.length == 5){
                    String bookName = booksParts[0];
                    String authorName = booksParts[1];
                    int pageCount = Integer.valueOf(booksParts[2]);
                    Genre genre = Genre.valueOf(booksParts[3]);
                    String isbn = booksParts[4];
                    Book book = new Book(bookName, authorName, pageCount, genre, isbn);
                    books.add(book);
                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }
        return books;
    }

    public void saveBooks() throws IOException{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Book book : holder.getBooks()){
                StringBuilder builder = new StringBuilder();
                builder.append(book.getBookName() + ",");
                builder.append(book.getAuthorName() + ",");
                builder.append(book.getPageCount() + ",");
                builder.append(book.getGenre() + ",");
                builder.append(book.getIsbn() + "\n");
                writer.append(builder.toString());
            }
            writer.close();
    }
}
