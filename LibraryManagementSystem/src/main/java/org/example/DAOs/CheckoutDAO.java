package org.example.DAOs;

import org.example.models.Book;
import org.example.models.Checkout;
import org.example.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class CheckoutDAO implements CheckoutDAOInterface{
    @Override
    public boolean deleteCheckout(int checkoutId) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            // SQL query to delete the checkout by checkout_id
            String sql = "DELETE FROM checkouts WHERE checkout_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, checkoutId);
            int rowsAffected = ps.executeUpdate(); // Execute the delete operation

            return rowsAffected > 0; // Returns true if the row was deleted successfully
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sorry, couldn't delete checkout.");
        }
        return false; // Return false if deletion fails
    }

    @Override
    public Checkout addNewCheckout(Checkout checkout) {
        //Try to get a connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            // create SQL statement
            String sql = "INSERT INTO checkouts (book_id, user_id, checkout_date, return_date) VALUES (?, ?, ?, ?)";
            // Make a prepared  statement to fill in the variable
            PreparedStatement ps = connection.prepareStatement(sql);
            // Use id parameter to set the variable with a ps.set() method
            ps.setInt(1, checkout.getBook_id_fk());
            ps.setInt(2, checkout.getUser_id_fk());
            ps.setString(3,checkout.getCheckout_date());
            ps.setString(4,checkout.getReturn_date());
            ps.executeUpdate();
            return checkout;
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return null;
    }

    @Override
    public ArrayList<Checkout> getAllCheckouts() {
        try(Connection connection = ConnectionUtil.getConnection()){
            // create SQL statement
            String sql = "SELECT * FROM checkouts";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Checkout> checkouts = new ArrayList<>();
            while(rs.next()){
                Checkout c = new Checkout(
                        rs.getString("checkout_date"),
                        rs.getString("return_date"),
                        rs.getInt("book_id"),
                        rs.getInt("user_id")
                );
                checkouts.add(c);
            }
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }
        return new ArrayList<>();
    }
}
