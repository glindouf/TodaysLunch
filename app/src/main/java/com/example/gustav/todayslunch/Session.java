package com.example.gustav.todayslunch;

/**
 * Created by ludvi on 24/11/2017.
 */

public class Session {

    private static Session session;

    public Restaurant currentRestaurant;
    public FakeRestaurantStore store;
    // private constructor to prevent other from creating Session objects
    private Session() {
        store = FakeRestaurantStore.getInstance();
    };

    static {
        session = new Session();
    }


    public static Session getInstance() {
        return session;
    }



}