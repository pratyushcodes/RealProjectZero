package org.example.DAOs;

import org.example.models.Book;
import org.example.models.User;
import org.example.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO implements BookDAOInterface{
    @Override
    public Book getFullAttributes(int id) {
        //Try to get a connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            // String that represents SQL query
            String sql = "SELECT * FROM books WHERE book_id = ?";
            // Make a prepared  statement to fill in the variable
            PreparedStatement ps = connection.prepareStatement(sql);
            // Use id parameter to set the variable with a ps.set() method
            ps.setInt(1, id);
            //Execute the query, save the result in resultSet
            ResultSet rs = ps.executeQuery(); //executing the query stored in the Prepared statement
            if(rs.next()) {
                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getString("author")
                );
                return book;
            }
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return null;
    }

    @Override
    public String getBookNameByID(int id) {
        //Try to get a connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            // String that represents SQL query
            String sql = "SELECT title FROM books WHERE book_id = ?";
            // Make a prepared  statement to fill in the variable
            PreparedStatement ps = connection.prepareStatement(sql);
            // Use id parameter to set the variable with a ps.set() method
            ps.setInt(1, id);
            //Execute the query, save the result in resultSet
            ResultSet rs = ps.executeQuery(); //executing the query stored in the Prepared statement
            if(rs.next()) {
                return rs.getString("title");
            }
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return null;
    }

    @Override
    public String getBookAuthorByID(int id) {
        //Try to get a connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            // String that represents SQL query
            String sql = "SELECT author FROM books WHERE book_id = ?";
            // Make a prepared  statement to fill in the variable
            PreparedStatement ps = connection.prepareStatement(sql);
            // Use id parameter to set the variable with a ps.set() method
            ps.setInt(1, id);
            //Execute the query, save the result in resultSet
            ResultSet rs = ps.executeQuery(); //executing the query stored in the Prepared statement
            if(rs.next()) {
                return rs.getString("author");
            }
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return null;
    }

    @Override
    public Book addLibraryBook(Book book) {
        //Try to get a connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            // create SQL statement
            String sql = "INSERT INTO books (title, genre, author) VALUES (?, ?, ?)";
            // Make a prepared  statement to fill in the variable
            PreparedStatement ps = connection.prepareStatement(sql);
            // Use id parameter to set the variable with a ps.set() method
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getGenre());
            ps.setString(3,book.getAuthor());

            ps.executeUpdate();
            return book;
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return null;
    }
}
