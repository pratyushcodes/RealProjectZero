package org.example.DAOs;

import org.example.models.Checkout;

import java.util.ArrayList;

public interface CheckoutDAOInterface {

    //A method to insert a new Checkout;

    //A method to get all Checkout histories;
    Checkout addNewCheckout(Checkout checkout);

    ArrayList<Checkout> getAllCheckouts();
}
