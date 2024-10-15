package org.example.models;
import java.util.*;

public class Checkout {
    private int checkout_id;
    private int book_id;
    private int user_id;
    private Date checkout_date;
    private Date return_date;

    public Checkout(){};

    public Checkout(int book_id,int user_id,Date checkout_date,Date return_date){

    }
}
