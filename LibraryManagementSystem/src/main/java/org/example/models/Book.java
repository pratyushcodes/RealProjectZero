package org.example.models;

public class Book {
    private int book_id;
    private String title;
    private String genre;
    private String author;

    public Book(){};

    public Book(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public Book(int book_id, String title, String genre, String author) {
        this.book_id = book_id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
