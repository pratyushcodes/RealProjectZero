package org.example;

import org.example.DAOs.BookDAO;
import org.example.DAOs.CheckoutDAO;
import org.example.DAOs.UserDAO;
import org.example.models.Book;
import org.example.models.Checkout;
import org.example.models.User;
import org.example.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // below method is trying to make a Connection to the database
        try(Connection connection = ConnectionUtil.getConnection()){
            System.out.println("Congratulations, your connection is successful");
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Sorry, connection failed.");
        }

        UserDAO uDao = new UserDAO();
        User s = uDao.getFullAttributes(13);
        System.out.println(s);

        BookDAO bDao = new BookDAO();
        Book b = bDao.getFullAttributes(1);
        String a = bDao.getBookAuthorByID(1);
        System.out.println(b);


        //testing out adding a new library user
        User x = new User("Billy","Walters","billywalters14@gmail.com");
//        uDAO.addLibraryUser(x);
        User y = new User("Eric","Jenkins","ericjenkins19@gmail.com");
//        uDAO.addLibraryUser(y);
        User z = new User("Jamarr","Chase","jamarrchase@bengals.com");
//        uDao.addLibraryUser(z);
        //testing out adding more books;
        Book nb = new Book("The Glass Castle", "memoir/autobiography","Jeannette Walls");
        Book nv = new Book("The Namesake","realistic fiction", "Jhumpa Lahiri");
        Book nz = new Book("Outlers","self help","Malcolm Gladwell");
        /* I spelled outliers wrong so I plan on updating it later */
//        bDao.addLibraryBook(nb);
//        bDao.addLibraryBook(nv);
//        bDao.addLibraryBook(nz);
        //added the books above for testing purposes

        CheckoutDAO cda = new CheckoutDAO();
        Checkout co = new Checkout("10/17/24","11/7/24",14,7);
        Checkout cod = new Checkout("10/17/24","11/7/24",13,5);
//        cda.addNewCheckout(co);
//        cda.addNewCheckout(cod);
    }


}