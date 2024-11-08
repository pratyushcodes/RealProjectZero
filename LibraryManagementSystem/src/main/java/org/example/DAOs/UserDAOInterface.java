package org.example.DAOs;

import org.example.models.User;

public interface UserDAOInterface {

    User getFullAttributes(int id);
    //A method that returns all the attributes of a particular user
    //A method that gets the users email by ID
    String getUserEmailByID(int id);
    //A method that gets the users full name by ID
    String getFullNameByID(int id);
    //A method that allows the addition of another library User
    User  addLibraryUser(User person);
    String updateUserEmail (int id, String newEmail);
    boolean deleteUser(int id);

    //A method that would create a potential new user
}
