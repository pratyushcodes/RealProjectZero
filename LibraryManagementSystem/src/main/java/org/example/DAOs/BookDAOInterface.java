package org.example.DAOs;
import org.example.models.Book;


public interface BookDAOInterface {

    Book getFullAttributes(int id);
    //A method that returns all the attributes of a particular book
    String getBookNameByID(int id);
    //a method that gets the book name by its ID number
    String getBookAuthorByID(int id);
    //a method that gets the book Author by its ID number
    Book addLibraryBook(Book book);
    //a method to add a library book to the package

}
