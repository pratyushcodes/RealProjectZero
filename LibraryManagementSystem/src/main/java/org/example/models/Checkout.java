package org.example.models;

public class Checkout {
    private int checkout_id;
    private String checkout_date;
    private String return_date;
    private Book books;
    private User users;
    /*Checkout will contain entire books and users
    objects instead of just the book id and user id */
    private int user_id_fk;
    private int book_id_fk;

    public Checkout(){};

    public Checkout(String checkout_date, int checkout_id, String return_date, Book books, User users) {
        this.checkout_date = checkout_date;
        this.checkout_id = checkout_id;
        this.return_date = return_date;
        this.books = books;
        this.users = users;
    }

    public Checkout(String checkout_date, String return_date, int user_id_fk, int book_id_fk) {
        this.checkout_date = checkout_date;
        this.return_date = return_date;
        this.user_id_fk = user_id_fk;
        this.book_id_fk = book_id_fk;
    }

    public int getCheckout_id() {
        return checkout_id;
    }

    public void setCheckout_id(int checkout_id) {
        this.checkout_id = checkout_id;
    }

    public String getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(String checkout_date) {
        this.checkout_date = checkout_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public int getUser_id_fk() {
        return user_id_fk;
    }

    public void setUser_id_fk(int user_id_fk) {
        this.user_id_fk = user_id_fk;
    }

    public int getBook_id_fk() {
        return book_id_fk;
    }

    public void setBook_id_fk(int book_id_fk) {
        this.book_id_fk = book_id_fk;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "checkout_id=" + checkout_id +
                ", checkout_date=" + checkout_date +
                ", return_date=" + return_date +
                ", books=" + books +
                ", users=" + users +
                ", user_id_fk=" + user_id_fk +
                ", book_id_fk=" + book_id_fk +
                '}';
    }
}
