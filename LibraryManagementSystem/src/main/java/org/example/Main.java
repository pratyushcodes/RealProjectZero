package org.example;

import org.example.DAOs.UserDAO;
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
        String u = uDao.getFullNameByID(3);
        System.out.println(u);

        User a = new User();
        int b = a.getUser_id();
        System.out.println(b);
    }
}