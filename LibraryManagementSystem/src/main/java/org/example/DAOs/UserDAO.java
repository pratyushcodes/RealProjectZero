package org.example.DAOs;
import org.example.models.User;
import org.example.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements UserDAOInterface{

    @Override
    public User getFullAttributes(int id) {
        //Try to get a connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            // String that represents SQL query
            String sql = "SELECT * FROM users WHERE user_id = ?";
            // Make a prepared  statement to fill in the variable
            PreparedStatement ps = connection.prepareStatement(sql);
            // Use id parameter to set the variable with a ps.set() method
            ps.setInt(1, id);
            //Execute the query, save the result in resultSet
            ResultSet rs = ps.executeQuery(); //executing the query stored in the Prepared statement
            if(rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email")
                );
                return user;
            }
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return null;
    }

    @Override
    public String getUserEmailByID(int id) {
        //Try to get a connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            // String that represents SQL query
            String sql = "SELECT email FROM users WHERE user_id = ?";
            // Make a prepared  statement to fill in the variable
            PreparedStatement ps = connection.prepareStatement(sql);
            // Use id parameter to set the variable with a ps.set() method
            ps.setInt(1, id);
            //Execute the query, save the result in resultSet
            ResultSet rs = ps.executeQuery(); //executing the query stored in the Prepared statement
            if(rs.next()) {
                return rs.getString("email");
            }
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return null;
    }

    @Override
    public User addLibraryUser(User person) {
        //Try to get a connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            // create SQL statement
            String sql = "INSERT INTO users (first_name, last_name, email) VALUES (?, ?, ?)";
            // Make a prepared  statement to fill in the variable
            PreparedStatement ps = connection.prepareStatement(sql);
            // Use id parameter to set the variable with a ps.set() method
            ps.setString(1, person.getFirst_name());
            ps.setString(2, person.getLast_name());
            ps.setString(3,person.getEmail());

            ps.executeUpdate();
            return person;
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return null;
    }

    @Override
    public String getFullNameByID(int id) {
        //Try to get a connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            // String that represents SQL query
            String sql = "SELECT full_name FROM users WHERE user_id = ?";
            // Make a prepared  statement to fill in the variable
            PreparedStatement ps = connection.prepareStatement(sql);
            // Use id parameter to set the variable with a ps.set() method
            ps.setInt(1, id);
            //Execute the query, save the result in resultSet
            ResultSet rs = ps.executeQuery(); //executing the query stored in the Prepared statement
            if(rs.next()) {
                return rs.getString("full_name");
            }
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return null;


    }
}
