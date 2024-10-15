package org.example.DAOs;

import org.example.models.User;

public interface UserDAOInterface {

    //A method that gets the users email by ID
    String getUserEmailByID(int id);
    //A method that gets the users full name by ID
    String getFullNameByID(int id);

    //A method that would create a potential new user
}
